
package com.jungwha.sayhello

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.hello.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        btnCamera.setOnClickListener {
            checkCameraPermission()
        }


    }
    fun checkCameraPermission(){
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) //카메라 권한이 있는지
        if(cameraPermission == PackageManager.PERMISSION_GRANTED) { //승인됨(0)
            startProcess()

        }else{
            requestPermission()
        }
    }
    fun startProcess(){
        Toast.makeText(this, "카메라 사용 권한이 승인되었습니다.", Toast.LENGTH_LONG).show()
    }
    val FLAG_CAMERA = 99
    fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), FLAG_CAMERA)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            FLAG_CAMERA ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startProcess()
                }else{
                    finish()
                }

            }
        }
    }
}