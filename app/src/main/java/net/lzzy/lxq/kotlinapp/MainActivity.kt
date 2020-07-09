package net.lzzy.lxq.kotlinapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var listView:ListView
    private var adapterDate= arrayOf("记事本","获取网页源码","RecyclerView","视频播放","数据库","item","item","item")
    private lateinit var arrayAdapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        initView()

    }
    private fun initView(){
        listView=findViewById(R.id.function_items)
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,adapterDate)
        listView.adapter=arrayAdapter

        listView.setOnItemClickListener { _, view, position, _ ->
            var textView:TextView= view as TextView
            Toast.makeText(this,"你点击的是"+textView.text,Toast.LENGTH_LONG).show()
            when(position){
                0->{
                    var cls=Class.forName("net.lzzy.lxq.kotlinapp.NoteActivity")
                    var intent=Intent(this,cls)
                    startActivity(intent)
                }
                1->{
                    var cls=Class.forName("net.lzzy.lxq.kotlinapp.GetHtmlCodeActivity")
                    var intent=Intent(this,cls)
                    startActivity(intent)
                }
                2->{
                    var intent=Intent(MainActivity@this,RecyclerActivity::class.java)
                    startActivity(intent)
                }
                3->{
                    var dialog=AlertDialog.Builder(this)
                    var editView=EditText(this)
                    dialog.setTitle("视频uri")
                    dialog.setView(editView)
                    dialog.setPositiveButton("确定",({ _, _ ->
                                startActivity(Intent(this,PlayActivity::class.java)
                                    .putExtra("uri",editView.text.toString()))
                            }))

                    dialog.setNegativeButton("取消",null)
                    dialog.show()
                }
                4->{
                    startActivity(Intent(applicationContext,SQLTableActivity::class.java))
                }

            }
        }
    }
}
