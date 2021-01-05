package com.jungwha.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<Holder>(){
    val listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) { //실제 화면에 그려주는 함수
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int { //몇개인지
        return listData.size
    }
}
class Holder(itemView:View):RecyclerView.ViewHolder(itemView){
    fun setMemo(memo:Memo){
        itemView.textNo.text = "${memo.no}" //str로
        itemView.textContent.text = memo.content
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm") //Long형태를 날짜폼에 넣어줌
        val datetime = sdf.format(memo.datetime)
        itemView.textDatetime.text = "$datetime"
    }
}