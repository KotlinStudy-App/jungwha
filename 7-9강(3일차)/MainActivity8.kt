package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intArray = intArrayOf(0,10,20,30,40,50,60,70,80) //배열 한번에 생성하기

        //for
        for (value in intArray){ // 배열사용가능
            Log.d("반복문", "value = $value")
        }
        //일반적으로 몇번의 횟수를 반복하는 형태
        for(index in 1 until 100 step 2){//until = 마지막값 제외 //step2 = 1씩건너뛰며
            //until 대신 downTo = 반대로
            Log.d("반복문", "indx = $index")
        }

        //while
        var out = 3
        while(out < 3){
            Log.d("while", "현재 out 카운트 = $out")
            out += 1
        }

        //do while
        do {
            Log.d("while", "현재 out 카운트 = $out")
        } while (out < 3) //while 조건에 맞지 않아도 do 뒤에가 한번 실행된다.
        // 반복할지는 조건으로 결정

        //control loop
        for(ind in 0..10){
            if (ind>5) break //continue (skip)도 같이 사용 가능능
            Log.d("포", "현재 숫자 $ind")
        }



    }
}