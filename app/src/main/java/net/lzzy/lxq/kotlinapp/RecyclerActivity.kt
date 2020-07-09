package net.lzzy.lxq.kotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recylcer.*

/*
*created by LXQ
*
*on 2020/7/6
*/


class RecyclerActivity :AppCompatActivity(){

    lateinit var textList:Array<String?>
    lateinit var imgList:Array<Int?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recylcer)
        initData()
        var myAdapter=MyRecyclerViewAdapter(applicationContext,textList,imgList)
        recycler_list.layoutManager=LinearLayoutManager(applicationContext)
        recycler_list.adapter=myAdapter
    }

    fun initData(){
        textList= arrayOfNulls(11)
        imgList= arrayOfNulls(11)
        (1..10).forEach {
            textList[it]="ok$it"
            imgList[it]=R.mipmap.ic_launcher_round
        }
    }
}