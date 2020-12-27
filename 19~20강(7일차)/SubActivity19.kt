package com.jungwha.sayhello

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val param = intent.getStringExtra("param") ///전달된값 받기
        Log.d("액티비티", "prarm$param")

        returnvalue.setOnClickListener {
            val intent = Intent()
            intent.putExtra("parma2", "돌려드립니다.")//다시 돌려주기
            setResult(Activity.RESULT_OK, intent) //정상적으로 되었다고 알려주는 코드
            finish() //subactivity 가 닫히도록
       }
   }
}