package com.lucasfagundes.roga_labs.feature.posts.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.roga_labs.databinding.FragmentPostBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

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
}