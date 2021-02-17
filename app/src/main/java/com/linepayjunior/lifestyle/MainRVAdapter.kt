package com.linepayjunior.lifestyle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRVAdapter(val context:Context, val list_model:ArrayList<Model>) : RecyclerView.Adapter<MainRVAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    // context의 내용을 받아 main_rv_item 이라는 레이아웃으로 변형시켜주겠다는 함수 (item이 어떻게 생겼는지를 정해준다고 보면 됨)
    // inflate한 변수를 Holder라는 클래스의 타입으로 변환시켜 return 한다.
        val value = LayoutInflater.from(context).inflate(R.layout.main_rv_item, parent, false)
        return Holder(value)

    }

    override fun getItemCount(): Int {
    // 출력되어야 하는 총 item의 갯수를 알려주는 함수

        return list_model.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    // holder 클래스의 bind 함수를 사용하여 item의 title 내용을 id:text_area인 Text view의 텍스트에 매핑시켜준다.

        holder.bind(list_model[position], context)

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // 각 image_View와 Text View에 내용을 넣어주는 함수를 선언하는 클래스
        val photo = itemView.findViewById<ImageView>(R.id.image_area)
        val title = itemView.findViewById<TextView>(R.id.text_area)

        fun bind (model:Model, context: Context){
            title.text = model.title
        }

    }
}