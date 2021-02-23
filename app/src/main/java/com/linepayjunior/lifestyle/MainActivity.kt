package com.linepayjunior.lifestyle

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(

            Model("취향별로 싹 다 정리한 찰떡 향수 추천서", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/d12b785ed2d34516bbaee2e9b03f51f8.png", "https://google.com"),
            Model("인스타그램 아이디에 활용하기 좋은 예쁜 영단어 64개 모음", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/afc8ff2ea839486fa4fd9212cacdd741.png", "https://1boon.kakao.com/onehomelife/lifetip1"),
            Model("아는 사람만 마신다는 주말에 마시기 딱 좋은 숨겨진 술 추천", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/11f4061d94dd417d9a7cbecedb88d1a7.png", "https://1boon.kakao.com/onehomelife/lifetip2"),
            Model("공차 알바생 피셜 제일 맛있게 먹는 꿀조합 8가지", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/9008f4a074504728af9650bec50c80ff.png", "https://1boon.kakao.com/onehomelife/lifetip3"),
            Model("취향별로 싹 다 정리한 찰떡 향수 추천서", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/d12b785ed2d34516bbaee2e9b03f51f8.png", "https://google.com"),
            Model("인스타그램 아이디에 활용하기 좋은 예쁜 영단어 64개 모음", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/afc8ff2ea839486fa4fd9212cacdd741.png", "https://1boon.kakao.com/onehomelife/lifetip1"),
            Model("아는 사람만 마신다는 주말에 마시기 딱 좋은 숨겨진 술 추천", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/11f4061d94dd417d9a7cbecedb88d1a7.png", "https://1boon.kakao.com/onehomelife/lifetip2"),
            Model("공차 알바생 피셜 제일 맛있게 먹는 꿀조합 8가지", "https://img1.daumcdn.net/thumb/S560x400/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/onehomelife/9008f4a074504728af9650bec50c80ff.png", "https://1boon.kakao.com/onehomelife/lifetip3")


        )

        // main Activity 의 Recycler view에 Data를 연결한 adapter 연결 성공
        val mAdapter = MainRVAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter


        // onItemClick
        mAdapter.itemClick = object : MainRVAdapter.ItemClick{
            override fun onClick1(view: View, position: Int) {
                Log.e("position: ", position.toString())

                val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                intent.putExtra("url", modelList.get(position).url)
                startActivity(intent)


            }

        }



         mRecyclerView.apply {
             layoutManager = GridLayoutManager(this@MainActivity, 2)
         }

        figure_1.setOnClickListener {
            figure_1.setBackgroundColor(Color.parseColor("#0f4c81"))
            figure_2.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_3.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_4.setBackgroundColor(Color.parseColor("#ffffff"))

            supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout_id,Section1Fragment())
                .commit()

        }

        figure_2.setOnClickListener {
            figure_1.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_2.setBackgroundColor(Color.parseColor("#fb6d5e"))
            figure_3.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_4.setBackgroundColor(Color.parseColor("#ffffff"))

        }

        figure_3.setOnClickListener {
            figure_1.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_2.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_3.setBackgroundColor(Color.parseColor("#90a6d1"))
            figure_4.setBackgroundColor(Color.parseColor("#ffffff"))

        }

        figure_4.setOnClickListener {
            figure_1.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_2.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_3.setBackgroundColor(Color.parseColor("#ffffff"))
            figure_4.setBackgroundColor(Color.parseColor("#86B144"))

        }


    }
}
