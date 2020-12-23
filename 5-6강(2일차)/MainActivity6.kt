package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var first = 300
        var second = 500
        var third = 270

        //비교연산자 <, >, >= , <=, ==, !=
        var result1 = first<500
        Log.d("compare", "첫번째 결과=${result1}")
        var result2 = second < 500
        Log.d("compare", "두번째 결과 = ${result2}")

        //논리연산자
        var logic1 = result1&&result2
        Log.d("compare", "논리연산 &&(and) 결과 = ${logic1}")
        var logic2 = result1 || result2
        Log.d("compare", "논리연산 ||(or) 결과 = ${logic2}")

        //부정연산자
        var logic3 = !result1
        Log.d("compare", "논리연산 !(not) 결과 = ${logic3}")


        //if
        var month = 6
        if (month > 9){
            Log.d("if", "가을 옷을 입습니다.")
        }else if(month < 9 && month >6){
            Log.d("if", "해수욕장을 갑니다.")

        }
        else{ Log.d("if", "집에 있습니다.")
            //위의 if 조건 실행 X일때 사용
        }




        //when- if문의 확장판
        when(month){
            6 -> {
                Log.d("when", "6월입니다.")
            }
            9 -> {
                Log.d("when", "9월입니다.")

            }
            10, 11 ->{
                Log.d("when", "가을입니다.")
            }
            in 6..8 ->{
                Log.d("when", "여름입니다.")
            }
            else -> {
                Log.d("when", "집에 있습니다..")
            }

        }
        when(month){ //코드가 한줄일때 더 간편함
            6 ->Log.d("when", "6월입니다.")
            9 ->Log.d("when", "9월입니다.")
            10, 11 ->Log.d("when", "가을입니다.")
            in 6..8 ->Log.d("when", "여름입니다.")
            else -> Log.d("when", "집에 있습니다..")
        }


    }
}