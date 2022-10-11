package com.example.beginning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beginning.database.AppDatabase

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        load()
    }

    override fun onResume() {
        super.onResume()
        load()
    }

    private fun load(){
        val db = AppDatabase.getDatabase(this)
        var list = db.userDao().getAll()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(list)
    }
}