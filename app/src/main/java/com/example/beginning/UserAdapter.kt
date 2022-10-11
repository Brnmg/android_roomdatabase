package br.com.fiap.begginng

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beginning.R
import com.example.beginning.database.User
import com.google.android.material.textfield.TextInputLayout

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
        var item = dataSet[position]

        var email = item.email
        var senha = item.password
        var nome = item.firstName
        var sobrenome = item.lastName
        var idade = item.age

        holder.textViewEmail.text = email.toString()
        holder.textViewSenha.text = senha.toString()
        holder.textViewNome.text = nome.toString()
        holder.textViewSobrenome.text = sobrenome.toString()
        holder.textViewIdade.text = idade.toString()
    }

    override fun getItemCount() = dataSet.size
}