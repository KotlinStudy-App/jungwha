package com.jungwha.kotilins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var parent = Parent()
        parent.showhouse()
        var child  = Child()
        child.showmoney()
        child.showhouse()
        var son = Son()
        var result1 = son.getnumber()//괄호안에 아무것도 안들어가면 result1 = 1
                                    //string 들어가면 result1 = 2
    }
}
//상속을 사용하는 이유
//1.기존에 작성도닌 코드를 재활용하기 위해서
//2.코드를 재활용하는데, 체계적인 구조로 사용하기 위해서
open class Parent{//open ㅡ상속가능이란 뜻
    var money = 50000000
    open var house = "강남 200평 아파트" //재정의할수있는 변수임

    open fun showhouse(){
        Log.d("클래스 ", "house = $house")
    }
}
class Child: Parent() {
    //상속받으면, 아빠클래서의 프로퍼티와 메서드를 내것처럼 사용가능
    override var house = "강남 10평 오피스텔" //재정의
    fun showmoney(){
        Log.d("클래스 ", "money = $money")}

    override fun showhouse(){
        Log.d("클래스 ", "house = $house")
    }
}
class Son{
    fun getnumber():Int{
        return 1
    }
    fun getnumber(param:String):Int{
        return 2   //이렇게 동일한 함수 여러개 만드는것 ㅡ 오버로드
    }
}