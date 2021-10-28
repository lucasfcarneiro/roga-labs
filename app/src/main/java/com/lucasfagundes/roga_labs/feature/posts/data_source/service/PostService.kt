package com.lucasfagundes.roga_labs.feature.posts.data_source.service

import com.lucasfagundes.roga_labs.feature.posts.data_source.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getPost(): Call<List<PostResponse>>
}