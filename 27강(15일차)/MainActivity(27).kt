package com.jungwha.camerakt

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity(var bitmap: Bitmap) : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1 //카메라 사진 촬영 요청코드
    lateinit var curPhotoPath:String //문자열 형태의 사진 경로 값 //lateinit var = 늦게 초기화 되는 var (초기값을 null로 시작하고 싶을 때)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPermission() //권한을 체크하는 메서드 수행
        btn_camera.setOnClickListener {
            takeCapture() // 기본 카메라 앱을 실행하여 사진 촬영.

        }


    }

    /**
     * 카메라 촬영
     */
    private fun takeCapture() {
        // 기본 카메라 앱 실행
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also{
                val photoFile: File? = try {
                    createImageFile()
                }catch(ex: IOException){
                    null
                }
                photoFile?.also{
                    val photoURI: Uri = FileProvider.getUriForFile( //Provider = 파일 제공
                        this,
                        "com.jungwha.camerakt.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)

                }
            }
        } //Intent = 앱 실행할때
    }

    /**
     * 이미지 파일 생성
     */
    private fun createImageFile(): File? {
        val timestamp:String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())//이미지 파일 이름
        val storageDir:File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timestamp}_", ".jpg", storageDir)
            .apply { curPhotoPath = absolutePath } //임시 파일 , 임시 경로

    }

    /**
     * 테드 퍼미션 설정
     */
    private fun setPermission() {
        val permission = object:PermissionListener{//테드 퍼미션에서 권한 구현을 하는 방법
            override fun onPermissionGranted() { // 설정해놓은 위험권한들이 허용되었을 경우 이 곳을 수행함
                Toast.makeText(this@MainActivity, "권한이 허용되었습니다.", Toast.LENGTH_SHORT).show() //Toast = 팝업 메시지
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { // 설정해놓은 위험 권한들 중 거부를 한 경우 이곳을 수행함
                Toast.makeText(this@MainActivity, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }

        }
        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해 주세요")
            .setDeniedMessage("권한을 거부하셨습니다. [앱설정] -> [권한] 항목에서 허용해주세요") //사용자가 거부를 했을경우 띄워줌
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { // startActivityForResult를 통해서 기본 카메라 앱으로부터 받아온 사진 결과값
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){ // 이미지를 성공적으로 가져왔으면
            val vitmap : Bitmap
            val file = File(curPhotoPath) //절대경로가 들어가있음 (이미지 파일 생성 부분)
            if (Build.VERSION.SDK_INT < 28){ //안드로이드 9.0(Pie) 버전보다 낮을 경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap) //이미지뷰에 기록


            }else{
                val decode = ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                )
                bitmap = ImageDecoder.decodeBitmap(decode)
                iv_profile.setImageBitmap(bitmap)

            }

            savePhoto(bitmap)

        }

    }

    /**
     * 갤러리에 저장
     */

    private fun savePhoto(bitmap: Bitmap) {
        val folderpath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/" // 사진 폴더로 저장하기 위한 경로선언
        val timestamp:String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder = File(folderpath)
        if(!folder.isDirectory){//현재 해당 경로에 폴더가 존재하지 않는다면
            folder.mkdirs() //make directory 줄임말, 해당경로에 폴더 자동으로 만들기
        }
        //실제적인 저장 처리
        val out = FileOutputStream(folderpath+fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        Toast.makeText(this, "사진이 앨범에 저장되었습니다.", Toast.LENGTH_SHORT).show()
    }
}