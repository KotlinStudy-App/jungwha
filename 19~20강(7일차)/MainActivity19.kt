
package com.jungwha.sayhello

import android.app.Activity
import android.content.Intent
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

        button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("param", "실제값") //sub activity 에 변수 전달
            startActivityForResult(intent, 99)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //resultCod = 정상적일때 Activity.RESULT_OK, data = Intent 값
        super.onActivityResult(requestCode, resultCode, data) //subactivity에서 값을 받기 위한 함수
        if(resultCode == Activity.RESULT_OK){//정상적일때
            val returnvalue = data?.getStringExtra("param2") ?: "None" //위에 intent?이므로
            Log.d("액티비티", "돌려받은 값=$returnvalue")

        }
    }
}