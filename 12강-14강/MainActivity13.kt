
package com.jungwha.sayhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.hello.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        //첫번째 표현법
        val listner = object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("리스너", "클릭되었습니다.")
            }
        }
        button.setOnClickListener(listner)


        //두번째 표현법법
        button.setOnClickListener { Log.d("리스너", "클릭되었습니다.") }

    }
}