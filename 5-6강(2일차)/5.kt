package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var varible = "홍길동"

        var variable2:String //type 지정, 앞으로 다른 type은 넣을수없다.
        variable2 = "안녕하세요"

        //코틀린의 기본 타입
        //실수형
        var wjdtn:Double = 23.0
//        var tlftn:Float = 123.5f //f를통해 실수라는것을 알려주어야함
        //정수형
//        var intValue:Int = 123456788
        var longValue:Long = 2_147_483_647
    //       var shortValue:Short = 123
//        var byteValue:Byte = 127
        //문자형
        var charValue:Char = 'a' //외따옴표
        var stringValue:String = "문자형 길이에 상관없이 입력가능"

        //불린형
        var booleanValue:Boolean = true

        val VALVALUE:Boolean = true // 변경불가

        var hello_world = "안녕 세상아"

    }
}