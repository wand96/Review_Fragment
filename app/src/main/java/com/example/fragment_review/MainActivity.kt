package com.example.fragment_review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    fun setFragment() {
        //프래그먼트를 삽입하는 과정은 하나의 트랜젝션으로 처리된다.
        val listFragment: ListFragment = ListFragment()
        //ListFragment를 생성
        val transaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저를 통해 트랜젝션을 시작하고 시작한 트랜젝션을 변수에 저장
        transaction.add(R.id.frameLayout, listFragment)
        //트랜젝션의 add메서드로 frameLayout을 id로 가진 레이아웃에 listFragment를 삽입
        transaction.commit()
        //모든 작업이 정상적으로 처리되었음을 트랜젝션에 알려주면서 작업을 반영
    }
}