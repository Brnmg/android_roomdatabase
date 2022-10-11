package com.example.beginning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.beginning.database.AppDatabase
import com.example.beginning.database.User
import com.example.beginning.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AppDatabase.getDatabase(this)
        val idUser = intent.getIntExtra("EXTRA_USER_ID", 0)

        if(idUser > 0){

            val email = intent.getStringExtra("EXTRA_USER_EMAIL")
            val senha = intent.getStringExtra("EXTRA_USER_SENHA")
            val nome = intent.getStringExtra("EXTRA_USER_NOME")
            val sobrenome = intent.getStringExtra("EXTRA_USER_SOBRENOME")
            val idade = intent.getStringExtra("EXTRA_USER_IDADE")

            binding.email.editText?.setText(email)
            binding.senha.editText?.setText(senha)
            binding.nome.editText?.setText(nome)
            binding.sobrenome.editText?.setText(sobrenome)
            binding.idade.editText?.setText(idade)
        }

        binding.buttonCadastrar.setOnClickListener{

            val nome = binding.nome.editText?.text.toString()
            val sobrenome = binding.sobrenome.editText?.text.toString()
            val email = binding.email.editText?.text.toString()
            val senha = binding.senha.editText?.text.toString()
            val idade = binding.idade.editText?.text.toString()

            if (idUser > 0) {

                db.userDao().update(User(idUser, nome, sobrenome, email, senha, idade))
                Toast.makeText(this, "Cadastro alterado com sucesso!", Toast.LENGTH_LONG).show()
                super.finish()
            }
            else {

                db.userDao().insert(User(0, nome, sobrenome, email, senha, idade))
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()

                //Limpa o formulário
                binding.email.editText?.setText("")
                binding.senha.editText?.setText("")
                binding.nome.editText?.setText("")
                binding.sobrenome.editText?.setText("")
                binding.idade.editText?.setText("")
            }
        }

        val buttonPerfis = findViewById<Button>(R.id.profiles)
        buttonPerfis.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}