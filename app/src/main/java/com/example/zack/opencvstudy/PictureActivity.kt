package com.example.zack.opencvstudy

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_picture.*
import org.opencv.android.Utils
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc
import org.opencv.android.OpenCVLoader
import org.opencv.android.BaseLoaderCallback
import org.opencv.android.LoaderCallbackInterface







class PictureActivity : AppCompatActivity() {

    private val TAG = "gao_chun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv.setImageDrawable(getDrawable(R.drawable.koala))
        }
        var bitmap : Bitmap =  BitmapFactory.decodeResource(resources,R.drawable.koala)
        iv.setImageBitmap(bitmap)
        change.setOnClickListener { v : View? ->
            var greyBitmap : Bitmap =  Bitmap.createBitmap(bitmap.width,bitmap.height,Bitmap.Config.RGB_565)
            var mat : Mat? = Mat()
            var grey : Mat? = Mat()
            Utils.bitmapToMat(bitmap,mat)
            Imgproc.cvtColor(mat,grey,Imgproc.COLOR_RGB2GRAY)
            Utils.matToBitmap(grey,greyBitmap)
            iv.setImageBitmap(greyBitmap)
            Toast.makeText(this, "zack", Toast.LENGTH_LONG).show()
        }

        recovery.setOnClickListener { v: View? ->
            iv.setImageBitmap(bitmap)
        }

        }

    override fun onResume() {
        super.onResume()
        //load OpenCV engine and init OpenCV library
//        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_9, applicationContext, mLoaderCallback)
        if (!OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
//        Log.i(FragmentActivity.TAG, "onResume sucess load OpenCV...")
    }

    private val mLoaderCallback = object : BaseLoaderCallback(this) {
        override fun onManagerConnected(status: Int) {
            when (status) {
                LoaderCallbackInterface.SUCCESS -> {
                    Log.i(TAG, "OpenCV loaded successfully")
//                    mOpenCvCameraView.enableView()
//                    mOpenCvCameraView.setOnTouchListener(this@CameraCalibrationActivity)
                }
                else -> {
                    super.onManagerConnected(status)
                }
            }
        }
    }

}


