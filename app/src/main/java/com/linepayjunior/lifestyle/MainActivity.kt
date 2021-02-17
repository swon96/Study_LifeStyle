package com.linepayjunior.lifestyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(

            Model("A0", "B0"),
            Model("A1", "B1"),
            Model("A2", "B2"),
            Model("A3", "B3")

        )

        // main Activity 의 Recycler view에 Data를 연결한 adapter 연결 성공
        val mAdapter = MainRVAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter


        // onItemClick
        mAdapter.itemClick = object : MainRVAdapter.ItemClick{
            override fun onClick1(view: View, position: Int) {
                Log.e("position: ", position.toString())
            }

        }



        // layout의 배치를 어떻게 할것인지 결정
//        val lm = LinearLayoutManager(this)
//        mRecyclerView.layoutManager = lm

         mRecyclerView.apply {
             layoutManager = GridLayoutManager(this@MainActivity, 2)
         }


    }
}
