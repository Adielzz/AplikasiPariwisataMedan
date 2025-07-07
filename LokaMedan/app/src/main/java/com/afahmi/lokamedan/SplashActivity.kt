package com.afahmi.lokamedan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var logoImageView: ImageView
    private lateinit var splashText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen: sembunyikan status bar & action bar
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )
        supportActionBar?.hide()

        setContentView(R.layout.activity_splash)

        // Inisialisasi View
        logoImageView = findViewById(R.id.logoImageView)
        splashText = findViewById(R.id.splashText)

        // Load animasi
        val logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_bounce)
        val textAnim = AnimationUtils.loadAnimation(this, R.anim.text_slide_fade)

        // Jalankan animasi
        logoImageView.startAnimation(logoAnim)
        splashText.startAnimation(textAnim)

        // Lanjut ke MainActivity setelah delay
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 2500) // 2.5 detik
    }
}
