
package com.jungwha.sayhello

import android.Manifest
import android.app.Activity
import android.content.Context
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
    val SP_NAME = "my_sp_storage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        writeSharedPreference("name", "마이클")
        val value = readSharedPreference("name")
        Log.d("프리퍼런스", "name = $value")




    }
    fun writeSharedPreference(key:String, value:String){
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE) //name = 저장소의이름
        val editor = sp.edit() //에디터 꺼내기
        editor.putString(key, value)
        editor.apply()
    }
    fun readSharedPreference(key:String) :String?{ //key에 해당하는 값을 복사
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.getString("name", "") //값이 없을때는 공백처리 하겠다.


    }
}