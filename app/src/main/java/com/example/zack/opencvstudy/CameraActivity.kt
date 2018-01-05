package com.example.zack.opencvstudy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        var intent : Intent = Intent()
        takePhoto.setOnClickListener { v: View? ->
            startActivity(intent.setClass(this,TakePhotoActivity::class.java))
        }
        
        recorder.setOnClickListener { v: View? ->  }
        
        faceDetect.setOnClickListener { v: View? ->  }

    }
}
