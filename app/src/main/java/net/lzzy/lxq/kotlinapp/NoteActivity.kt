package net.lzzy.lxq.kotlinapp

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note.*

/*
*created by LXQ
*
*on 2020/7/4
*/


class NoteActivity:AppCompatActivity(){

    private lateinit var read:SharedPreferences
    private lateinit var edition:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        read=getSharedPreferences("note", Context.MODE_PRIVATE)
        edition=read.edit()

        ed_note_title.setText(read.getString("title",""))
        ed_note_context.setText(read.getString("context",""))

        btn_note_save.setOnClickListener { _->
            var titleText=ed_note_title.text.toString()
            var conText=ed_note_context.text.toString()
            if (titleText != "" && conText != ""){
                edition.putString("title",titleText)
                edition.putString("context",conText)
                edition.commit()
                Toast.makeText(this,"已保存",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"内容不能为空",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        AlertDialog.Builder(this)
            .setTitle("提示")
            .setMessage("确定要退出吗？")
            .setPositiveButton("确定",({_,_->finish()}))
            .setNegativeButton("取消",null)
            .show()
    }
}