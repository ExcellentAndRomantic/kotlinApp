package net.lzzy.lxq.kotlinapp

import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_play_online.*

/*
*created by LXQ
*
*on 2020/7/7
*/


class PlayActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(1024,1024)
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_play_online)
        supportActionBar?.hide()
        video_view.setMediaController(MediaController(this))
        video_view.setVideoURI(Uri.parse(intent.getStringExtra("uri")))
        video_view.start()
        video_view.setOnCompletionListener {
            video_view.start()
        }
    }
}