package com.santosgo.houseofthedragon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.houseofthedragon.R

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)


        val nombre = intent.getStringExtra("NAME")


        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        tvNombre.text = "Sir $nombre, es el momento de que tomes una dificil elección... "

        val tvSelectionInfo = findViewById<TextView>(R.id.tvSelectionInfo)
        val cbRaenira = findViewById<CheckBox>(R.id.cbRaenira)
        val cbAegon = findViewById<CheckBox>(R.id.cbAegon)
        val btnKneel = findViewById<Button>(R.id.btnKneel)

        val updateMessage = {
            when {
                cbRaenira.isChecked && cbAegon.isChecked -> tvSelectionInfo.text = getString(R.string.both_chosen)
                cbRaenira.isChecked -> tvSelectionInfo.text = getString(R.string.raenira_chosen)
                cbAegon.isChecked -> tvSelectionInfo.text = getString(R.string.aegon_chosen)
                else -> tvSelectionInfo.text = getString(R.string.no_decision)
            }
        }

        cbRaenira.setOnCheckedChangeListener { _, _ -> updateMessage() }
        cbAegon.setOnCheckedChangeListener { _, _ -> updateMessage() }

        btnKneel.setOnClickListener {
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("SELECTION", tvSelectionInfo.text.toString())
            startActivity(intent)
        }
    }
}

