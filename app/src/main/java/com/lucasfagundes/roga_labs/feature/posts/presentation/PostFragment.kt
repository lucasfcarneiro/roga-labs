package com.lucasfagundes.roga_labs.feature.posts.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.lucasfagundes.roga_labs.databinding.FragmentPostBinding
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.PostModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.widget.Toast
import com.lucasfagundes.roga_labs.feature.posts.presentation.adapter.CommentListAdapter
import com.lucasfagundes.roga_labs.feature.posts.presentation.adapter.PostListAdapter
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.CommentModel

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding
    private val viewModel: PostsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleObserver()
    }

    private fun handleObserver() {
        viewModel.postList.observe(
            viewLifecycleOwner,
            Observer(::handleRecyclerView)
        )

        viewModel.error.observe(
            viewLifecycleOwner,
            Observer(::handleError)
        )

        viewModel.commentList.observe(viewLifecycleOwner,
            Observer (::handleComment))
    }

    private fun handleRecyclerView(list: List<PostModel>) {
        val postAdapter = PostListAdapter(list)
        binding.recentPostRecyclerView.adapter = postAdapter
    }

    private fun handleError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun handleComment(list: List<CommentModel>){
        val commentAdapter = CommentListAdapter(list)
        binding.
    }
}





