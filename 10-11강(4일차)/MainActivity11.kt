package com.jungwha.kotilins

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myName : String = "메시"
        var number : Int? = null //1.nullable
        var newVarible : Activity? = null
        Log.d("Null Test", "문자의 길이는 = ${myName.length}")//string으로 초기화 했기때문에 쓸수 있음
        var number2:Int = 30
        var result = number2.plus(50) //컨트롤키+Int클릭으로 무슨기능있는지 확인가능
        var resultt = number?.plus(37) ?:51 //Null Pointer Exception -> ?를통해 다음을 실행하지 않게함(2.safe call)
                                                //?:(3. Elvis Expression) -> number 가 null일 경우에는, result 에 37을 넣어라
        var result2 = resultt.plus(53)
    }
}