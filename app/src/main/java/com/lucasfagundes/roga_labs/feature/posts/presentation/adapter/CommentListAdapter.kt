package com.lucasfagundes.roga_labs.feature.posts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.roga_labs.databinding.PostItemCommentRecyclerViewBinding
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.CommentModel

class CommentListAdapter(private val list: List<CommentModel>) :
    RecyclerView.Adapter<CommentListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemCommentRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: PostItemCommentRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(commentItem: CommentModel){
                with(binding){
                    userName.text = commentItem.name
                    userEmail.text = commentItem.email
                    userComment.text = commentItem.comment
                }
            }
    }
}