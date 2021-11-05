package com.lucasfagundes.roga_labs.feature.posts.data_remote.data_source

import com.lucasfagundes.roga_labs.feature.posts.data_remote.service.PostService

class PostRemoteDataSource(private val service : PostService){

    fun getPostsFromSource()= service.getPost()
    fun getCommentsFromSource(postId:Int)= service.getComments(postId)
}
