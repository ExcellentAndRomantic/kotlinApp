package net.lzzy.lxq.kotlinapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
*created by LXQ
*
*on 2020/7/6
*/


open class MyRecyclerViewAdapter(context:Context,textList:Array<String?>,imgList: Array<Int?>)
    :RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    var textList=textList
    var context=context
    var imgList=imgList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return textList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.titleView.text= textList[position]
        holder.titleView.post {
            holder.titleView.text= textList[position]
        }
        holder.img.setImageResource(R.mipmap.ic_launcher_round)
    }

    class MyViewHolder(item: View):RecyclerView.ViewHolder(item){

        var titleView:TextView = item.findViewById(R.id.item_text)
        var img:ImageView=item.findViewById(R.id.item_img)

    }
}