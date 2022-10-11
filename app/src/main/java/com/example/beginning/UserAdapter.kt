package com.example.beginning

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beginning.database.User

class UserAdapter(private val dataSet: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewEmail: TextView
        val textViewSenha: TextView
        val textViewNome: TextView
        val textViewSobrenome: TextView
        val textViewIdade: TextView

        init {
            textViewEmail = view.findViewById(R.id.email)
            textViewSenha = view.findViewById(R.id.senha)
            textViewNome = view.findViewById(R.id.nome)
            textViewSobrenome = view.findViewById(R.id.sobrenome)
            textViewIdade = view.findViewById(R.id.idade)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]

        val email = item.email
        val senha = item.password
        val nome = item.firstName
        val sobrenome = item.lastName
        val idade = item.age

        holder.textViewEmail.text = email.toString()
        holder.textViewSenha.text = senha.toString()
        holder.textViewNome.text = nome.toString()
        holder.textViewSobrenome.text = sobrenome.toString()
        holder.textViewIdade.text = idade.toString()

        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context, CadastroActivity::class.java).apply {
                putExtra("EXTRA_USER_ID", item.uid)
                putExtra("EXTRA_USER_EMAIL", item.email)
                putExtra("EXTRA_USER_SENHA", item.password)
                putExtra("EXTRA_USER_NOME", item.firstName)
                putExtra("EXTRA_USER_SOBRENOME", item.lastName)
                putExtra("EXTRA_USER_IDADE", item.age)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}