package com.lucasfagundes.roga_labs.feature.posts.di

import com.lucasfagundes.roga_labs.feature.posts.presentation.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postsModule = module {
    viewModel { PostsViewModel(get()) }
}