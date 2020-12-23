package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var variable = 157


        //배열
        // int -> IntArray
        var intArr:IntArray = IntArray(10)
        //python의 list 처럼 사용가능
        intArr[0] = 10
        intArr[1] = 20
        intArr[9] = 100
        Log.d("배열", "9번 인덱스의 값=${intArr[9]}")

        var weekArray = CharArray(7)
        weekArray[0] = '월'
        weekArray[1] = '화'
        // ....
        weekArray[6] = '일'

        //컬렉션 //크기안정해져있음 //제네릭
        var mutablelist = mutableListOf<Int>()
        //값넣기
        mutablelist.add(5) //자동적으로 index = 0
        mutablelist.add(63) //index = 1
        //....
        Log.d("컬렉션", "1번 인덱스의 값 = ${mutablelist.get(1)}")


        //맵 (키, 벨류)
        var mutableMap = mutableMapOf<String, String>()
        mutableMap.put("변수1","값1")
        mutableMap.put("변수2", "값2")
        Log.d("맵", "1번 인덱스의 값 = ${mutableMap.get("변수1")}")



    }
}