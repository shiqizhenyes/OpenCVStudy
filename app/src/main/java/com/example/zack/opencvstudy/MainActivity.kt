package com.example.zack.opencvstudy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent : Intent = Intent()
        picture.setOnClickListener { v: View? ->
            startActivity(intent.setClass(this,PictureActivity::class.java))
        }

        camera.setOnClickListener {v: View? ->
            startActivity(intent.setClass(this,CameraActivity::class.java))
        }

    }
}
