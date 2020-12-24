package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //클래스 사용
        //1.초기화
        var cls = 클래스()//인스턴스 = 메모리에 로드되어있는 클래스
        cls.variable //변수사용
        cls.function()//함수사용
        //2.companion object
        Log.d("태그", "메세지")
    }

    }
class Log{
    companion object{//초기화 없이 사용 가능
    var variable = "넌 누구"
    fun d(tag:String, msg:String) {
        print("[$tag]: $msg")
        }
    }
}
//변수(프로퍼티)와 함수(메서드)의 모음
class 클래스 {
    init{
        //클래스를 초기화하면 호출된다.
    }
    var variable:String = ""//변수 ㅡ 프로퍼티
    fun function(){//함수 ㅡ 메서드
        var vaiable_local = ""
    }
}