
package com.jungwha.sayhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.hello.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello)
        radiogroup.setOnCheckedChangeListener { group, checkedId ->  //그룹이름, 체크된것의 id
            when(checkedId) {
                R.id.radioapple -> Log.d("라디오", "사과가 선택되었습니다.")
                R.id.radiobanana -> Log.d("라디오", "바나나가 선택되었습니다.")
                R.id.radioorange -> Log.d("라디오", "오렌지가 선택되었습니다.")

            }
        }

    }
}