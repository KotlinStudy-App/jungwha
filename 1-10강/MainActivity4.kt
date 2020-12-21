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

        var myname = "여정화"
        Log.d(TAG, "my name=$myname")
        myname = "여정화2"
        Log.d(TAG, "my name=$myname")
        val myAge = 19
        Log.d(TAG, "pi=$myAge")

        var numbers = "1,2,3,4,5,6"
        var thisWeekNumbers = "5,6,7,8,9,10"
        if (numbers == thisWeekNumbers){
            Log.d(TAG, "당첨되었습니다.")
        }else{
            Log.d(TAG, "당첨되지 않았습니다.") >>>MainActivity 검색했을 때 당첨되지 않았습니다 출력
            
        }

        for(idx in 1..10){
            Log.d(TAG, "현재 숫자는 ${idx} 입니다.")

        }


    }
}
