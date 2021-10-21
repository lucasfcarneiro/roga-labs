package com.lucasfagundes.roga_labs.feature.posts.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.roga_labs.databinding.PostItemRecyclerViewBinding

class PostListAdapter (private val x : Int) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =PostItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = x //tamanho da lista que chegar


    class ViewHolder(private val binding: PostItemRecyclerViewBinding):
        RecyclerView.ViewHolder(binding.root){

    }

}