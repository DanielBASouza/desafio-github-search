package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.repositoryName.text = repositories[position].name
        holder.language.text = repositories[position].language
        holder.watchers.text = repositories[position].watchersCount.toString()
        holder.stars.text = repositories[position].stargazersCount.toString()

        // Exemplo de click no item
        holder.itemView.setOnClickListener {
         carItemLister(repositories[position])
        }

//         Exemplo de click no btn Share
        holder.btnCompartilhar.setOnClickListener {
            btnShareLister(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repositoryName: TextView
        val language: TextView
        val watchers: TextView
        val stars: TextView


        val btnCompartilhar: ImageView


        init {
            view.apply {
                repositoryName = findViewById(R.id.tv_repository_name)
                language = findViewById(R.id.tv_language)
                watchers = findViewById(R.id.tv_watchers)
                stars = findViewById(R.id.tv_stars)
                btnCompartilhar = findViewById(R.id.iv_share)
            }
        }
    }
}


