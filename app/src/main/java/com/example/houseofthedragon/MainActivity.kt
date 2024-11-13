package com.santosgo.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.houseofthedragon.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.getBooleanExtra("Exit",false))
            finish()

        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        btnAnswer.setOnClickListener {
            goToElection()
        }
    }

    fun goToElection() {
        val etNombre = findViewById<EditText>(R.id.etName)
        val nombre = etNombre.text.toString()

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Debes introducir un nombre", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this@MainActivity, ElectionActivity::class.java)
            intent.putExtra("NAME", nombre)
            startActivity(intent)
        }
    }



    companion object {
        const val LIFECLICLE = "LifeCycle"
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECLICLE, "La Activity ha sido reiniciada (Restarted)")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECLICLE, "La Activity ha sido iniciada (Started)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECLICLE, "La Activity ha pasado a primer plano (Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECLICLE, "La Activity ha sido pausada (Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECLICLE, "La Activity ha sido parada (Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECLICLE, "La Activity ha sido destruida (Destroyed)")
    }


}



