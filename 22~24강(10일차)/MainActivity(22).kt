
package com.jungwha.sayhello

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.hello.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        setFragment()



    }
    fun setFragment(){
        //1. 삽입할 프래그먼트 생성
        val fragment = ListFragment()
        //2. 삽입 트랜젝션 시작
        val transaction = supportFragmentManager.beginTransaction()
        //3. 트렌젝션을 통해 프래그먼트 삽입
        transaction.add(R.id.fram_layout, fragment)
        //4. 커밋
        transaction.commit()
    }
    fun goDetail(){
        //1. 삽입할 프래그먼트 생성
        val detail = DetailFragment()
        //2. 삽입 트랜젝션 시작
        val transaction = supportFragmentManager.beginTransaction()
        //3. 트렌젝션을 통해 프래그먼트 삽입
        transaction.add(R.id.fram_layout, detail)
        //4. 뒤로가기 버튼을 사용하기 위한 처리
        transaction.addToBackStack("detail")
        //5. 커밋
        transaction.commit()
    }
    fun goBack() {
        onBackPressed() //뒤로가기
    }

}