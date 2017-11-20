package com.programmingschool.gradienttransition

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    var animationDrawable: AnimationDrawable? = null
    var relativeLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        relativeLayout = findViewById<View>(R.id.relativeLayout) as RelativeLayout
        animationDrawable = relativeLayout!!.background as AnimationDrawable
        animationDrawable!!.setEnterFadeDuration(2000)
        animationDrawable!!.setExitFadeDuration(2000)
    }

    override fun onResume() {
        super.onResume()
        if (animationDrawable != null && !animationDrawable!!.isRunning)
            animationDrawable!!.start()
    }

    override fun onPause() {
        super.onPause()
        if (animationDrawable != null && animationDrawable!!.isRunning)
            animationDrawable!!.stop()
    }
}
