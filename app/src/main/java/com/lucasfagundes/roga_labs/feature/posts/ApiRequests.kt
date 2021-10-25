package com.lucasfagundes.roga_labs.feature.posts

import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {
    @GET("posts")
    fun getPostData(): Call<List<PostModel>>
}