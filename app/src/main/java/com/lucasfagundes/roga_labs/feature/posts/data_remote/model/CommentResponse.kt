package com.lucasfagundes.roga_labs.feature.posts.data_remote.model

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("postId")
    val postId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("body")
    val body: String?
)
