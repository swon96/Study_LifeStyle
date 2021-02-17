package com.linepayjunior.lifestyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(

            Model("A1", "B1"),
            Model("A2", "B2")

        )

        // main Activity 의 Recycler view에 Data를 연결한 adapter 연결 성공
        val mAdapter = MainRVAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter

        // layout의 배치를 어떻게 할것인지 결정
        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm

    }
}
