package com.androiddevs.mvvmnewsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.data.local.entity.ArticleEntity
import com.androiddevs.mvvmnewsapp.databinding.ItemArticlePreviewBinding
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var listNewsAdapter = ArrayList<ArticleEntity>()
    private var onItemClickLister: ((ArticleEntity) -> Unit)? = null
    fun setOnItemClickListener(listener: (ArticleEntity) -> Unit){
        this.onItemClickLister = listener
    }
    private val differCallback = object : DiffUtil.ItemCallback<ArticleEntity>(){
        override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem.url == newItem.url

        }

        override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
            return oldItem == newItem

        }
    }
    val differ = AsyncListDiffer(this,differCallback)
    fun setNewsAdapter(listNewsAdapter: List<ArticleEntity>?){
        if (listNewsAdapter == null) return
        this.listNewsAdapter.clear()
        this.listNewsAdapter.addAll(listNewsAdapter)
        notifyDataSetChanged()
    }
    inner class ViewHolder(private val binding : ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listNewsAdapter: ArticleEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(listNewsAdapter.urlToImage)
                    .into(binding.ivArticleImage)
                tvDescription.text = listNewsAdapter.description
                tvTitle.text = listNewsAdapter.title
                tvPublishedAt.text = listNewsAdapter.publishedAt
                listNewsAdapter.source?.name?.let {
                    tvSource.text = it
                }
                setOnItemClickListener {
                    onItemClickLister?.let {
                        it(listNewsAdapter)
                    }
                }


            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNewsAdapter[position])
    }

    override fun getItemCount(): Int {
        return listNewsAdapter.size
    }

}