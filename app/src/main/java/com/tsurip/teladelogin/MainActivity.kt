package com.tsurip.teladelogin

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.util.Pair
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var SPLASH_SCREEN:Long = 5000

    private lateinit var topAnim:Animation; private lateinit var botAnim:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //Animações
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim)
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bot_anim)

        //Ganchos

        imgNuvem.animation = topAnim; imgRec1.animation = topAnim; imgRec2.animation = topAnim; imgRec3.animation = topAnim
        txtYoulCloud.animation = botAnim; txtSlogan.animation  = botAnim

        Handler().postDelayed({
            val inten = Intent(this@MainActivity,Login::class.java)
            val parList = Pair<View,String>(imgNuvem, "logo_image")

            var options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity,parList)

            startActivity(inten, options.toBundle())
            finish()
            }, SPLASH_SCREEN)
    }


}