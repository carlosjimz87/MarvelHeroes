package com.carlosjimz87.marvelheroes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        var motionLayout:MotionLayout = findViewById(R.id.motionLayout)
        motionLayout.addTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                   startActivity(Intent(this@SplashScreen,MainActivity::class.java))
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

        })
    }


}