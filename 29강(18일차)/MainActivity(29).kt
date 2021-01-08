package com.jungwha.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${now}"
        }

        //while(true){
        //  var now = System.currentTimeMillis()
        //  textView2.text = "무한루프 : ${now}" //main thread가 너무 바빠서 화면 처리 불가능
        // }

        var thread = ThreadClass1()
        thread.start()

    }


    inner class ThreadClass1 :Thread(){ //개발자가 만드는 스레드
        override fun run(){
            while(true){
                SystemClock.sleep(100) //100ms만큼 이부분에서 쉰다.
                var now = System.currentTimeMillis()
                Log.d("test1", "thread : ${now}")
                // 앱을 닫아도 Log는 계속 출력된다. main thread가 아니기 때문이다.

                textView2.text = "thread : ${now}"

            }

        }


    }
}