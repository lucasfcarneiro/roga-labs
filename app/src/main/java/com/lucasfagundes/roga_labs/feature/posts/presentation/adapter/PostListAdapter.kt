package com.lucasfagundes.roga_labs.feature.posts.presentation.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.roga_labs.databinding.PostItemRecyclerViewBinding
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.PostModel
import com.lucasfagundes.roga_labs.feature.posts.utils.AdapterItemWithParameterClickListener

class PostListAdapter(private val list: List<PostModel>) :
    RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    var itemClickListener: AdapterItemWithParameterClickListener<Pair<Int,String>> = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            PostItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: PostItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postItem: PostModel) {
            with(binding){
                postTitle.text = postItem.title
                postBody.text = postItem.body
            }
            itemView.setOnClickListener {
                itemClickListener (Pair(postItem.id,postItem.title))
            }
        }
    }
}