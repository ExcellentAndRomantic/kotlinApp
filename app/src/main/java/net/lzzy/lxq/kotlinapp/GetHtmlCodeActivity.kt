package net.lzzy.lxq.kotlinapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_html_code.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

/*
*created by LXQ
*
*on 2020/7/4
*/


class GetHtmlCodeActivity :AppCompatActivity(){

    lateinit var shared: SharedPreferences
    
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        setContentView(R.layout.activity_get_html_code)

        shared=getSharedPreferences("data", Context.MODE_PRIVATE)

        ed_show_code.text=shared.getString("code_data","等待数据")

        btn_get.setOnClickListener{

            Thread(Runnable {
                var urlString=ed_url.text.toString()
                var urlObj= URL(urlString)
                var connection=urlObj.openConnection()
                var reader = InputStreamReader(connection.getInputStream())
                var buffer= BufferedReader(reader)
                var code=""
                buffer.forEachLine {
                    code+=it
                }
                runOnUiThread{
                    ed_show_code.text = code
                }
            }).start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var edition=shared.edit()
        edition.putString("code_data",ed_show_code.text.toString())
        edition.commit()
        Toast.makeText(GetHtmlCodeActivity@this,"onDestroy()",Toast.LENGTH_SHORT).show()
    }
}
