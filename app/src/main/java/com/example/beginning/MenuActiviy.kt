package com.example.beginning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_activiy)

        val sobreButton = findViewById<Button>(R.id.sobreButton)
        sobreButton.setOnClickListener {
            val intent  = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }

        val buttonPerfis = findViewById<Button>(R.id.profiles)
        buttonPerfis.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }


}