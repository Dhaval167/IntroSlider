package com.drj.viewpager2.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import com.bumptech.glide.Glide
import com.drj.viewpager2.R
import kotlinx.android.synthetic.main.activity_home.*
import java.io.File

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageUri = "https://media.tenor.com/images/c51500433e6f6fff5a8c362335bc8242/tenor.gif"
       val storageImage = File(Environment.getExternalStorageDirectory(),"Papa.jpg")

        videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4")
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()


        Glide.with(this).load(imageUri).placeholder(R.mipmap.ic_launcher_round).into(iv_imageView)
    }
}