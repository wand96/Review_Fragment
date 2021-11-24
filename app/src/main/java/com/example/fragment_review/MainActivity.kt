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


        //번들을 하나 생성 후 전달할 값을 담음
        var bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20210101)

        //값이 담긴 번들을 프래그먼트의 arguments에 담음
        listFragment.arguments = bundle

        //ListFragment를 생성
        val transaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저를 통해 트랜젝션을 시작하고 시작한 트랜젝션을 변수에 저장
        transaction.add(R.id.frameLayout, listFragment)
        //트랜젝션의 add메서드로 frameLayout을 id로 가진 레이아웃에 listFragment를 삽입
        transaction.commit()
        //모든 작업이 정상적으로 처리되었음을 트랜젝션에 알려주면서 작업을 반영
    }

    fun goDetail() {
        val detailFragment = DetailFragment()   //DetailFragment 생성

        val transaction = supportFragmentManager.beginTransaction()
        //프래그먼트 매니저를 통해 트랜젝션을 시작하고 시작한 트랜젝션을 변수에 저장

        transaction.addToBackStack("detail")
        //addToBackStack을 사용하면 프래그먼트를 백스택에 담아둘 수 있습니다.
        //스마트폰의 뒤로가기 버튼을 이용할 수 있게 해줌

        transaction.add(R.id.frameLayout, detailFragment)
        //트랜젝션의 add메서드로 frameLayout을 id로 가진 레이아웃에 listFragment를 삽입
        transaction.commit()
        //모든 작업이 정상적으로 처리되었음을 트랜젝션에 알려주면서 작업을 반영
    }

    fun goBack() {
        //Back버튼 클릭 시 호출될 메서드
        onBackPressed()
    }
}