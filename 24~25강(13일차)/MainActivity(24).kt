
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
import java.io.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        val internalDir = filesDir.absolutePath //내부저장소의 절대경로
        val filename = "first.txt"
        val content = "파일 내용 쓰기\n 01. 안녕하세요 \n02.두번째 줄입니다."
//        writeTextFile(internalDir, filename, content)
        val result = readTextFile(internalDir+"/"+filename)
        Log.d("파일내용", result)
    }
    fun readTextFile(fullpath:String) : String{
        val file = File(fullpath)
        if(!file.exists()) return ""

        val reader = FileReader(file)
        val buffer = BufferedReader(reader)

        var temp:String? = ""
        var result = StringBuffer()

        while (true){
            temp = buffer.readLine() //줄단위로 읽어서 임시 저장
            if (temp == null) break
            else result.append(temp).append("\n") //줄변환
        }
        buffer.close()
        return result.toString() //string으로 변환하여 return
    }
    fun writeTextFile(directory:String, filename:String, content:String) {

        val dir = File(directory)
        if(!dir.exists()){ //dir이 없으면
            dir.mkdirs() //생성

        }
        val fullpath = "$directory/$filename"
        val writer = FileWriter(fullpath)
        val buffer = BufferedWriter(writer) //쓰기속도 향상
        buffer.write(content)
        buffer.close()

    }
}