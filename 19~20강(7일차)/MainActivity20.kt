
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

        val data = listOf("-선택", "월", "화", "수", "목", "금", "토", "일")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        spinner.adapter = adapter
        spinner.onItemSelectedListener  = object :AdapterView.OnItemSelectedListener{ //선택한것 나타내기
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedValue = data[position]
                textView.text = selectedValue
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


    }
}