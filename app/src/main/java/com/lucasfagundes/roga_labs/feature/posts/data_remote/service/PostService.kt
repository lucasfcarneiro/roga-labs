package com.lucasfagundes.roga_labs.feature.posts.data_remote.service

import com.lucasfagundes.roga_labs.feature.posts.data_remote.model.CommentResponse
import com.lucasfagundes.roga_labs.feature.posts.data_remote.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    fun getPost(): Call<List<PostResponse>>

    @GET("posts/{post_id}/comments")
    fun getComments(@Path("post_id")postId:Int):Call<List<CommentResponse>>
}