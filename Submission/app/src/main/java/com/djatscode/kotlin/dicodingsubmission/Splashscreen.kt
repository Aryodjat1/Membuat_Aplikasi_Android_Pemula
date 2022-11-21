package com.djatscode.kotlin.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        supportActionBar?.hide()

        CoroutineScope(Dispatchers.Main).launch {
            delay(5000)
            startActivity(Intent(this@Splashscreen, MainActivity::class.java))
            finish()
        }
    }
}