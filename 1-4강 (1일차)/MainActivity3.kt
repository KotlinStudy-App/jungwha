package com.jungwha.sayhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botton_Log.setOnClickListener {
            Log.d(TAG,"Hello, Kotlin") >>>버튼을 클릭하면, Log 창에서 MainActivity라 검색했을때 Hello Kotlin이뜬다.
        }



    }
}
