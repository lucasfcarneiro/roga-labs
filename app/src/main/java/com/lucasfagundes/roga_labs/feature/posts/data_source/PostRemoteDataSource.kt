package com.lucasfagundes.roga_labs.feature.posts.data_source

import com.lucasfagundes.roga_labs.feature.posts.data_source.service.PostService

class PostRemoteDataSource(private val service : PostService){

    fun getPosts()= service.getPost()
}
