package com.santosgo.houseofthedragon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.houseofthedragon.R

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val finalMessage = intent.getStringExtra("SELECTION")
        tvFinalMessage.text = finalMessage

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}
