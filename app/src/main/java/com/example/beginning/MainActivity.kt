package com.example.beginning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCadastro = findViewById<Button>(R.id.clique)
        buttonCadastro.setOnClickListener {
            val intent  = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

    }
}