package com.lucasfagundes.roga_labs.feature.posts.presentation

import com.lucasfagundes.roga_labs.feature.posts.data_source.model.PostResponse
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.PostModel

object PostMapper {

    fun toPresentation(postResponseList: List<PostResponse>?): List<PostModel> {
        return if (postResponseList.isNullOrEmpty()) {
            emptyList()
        } else {
            parsePostList(postResponseList)
        }
    }

    private fun parsePostList(postResponseList: List<PostResponse>): List<PostModel> =
        postResponseList.map {
            PostModel(
                userId = it.userId ?: 0,
                id = it.id ?: 0,
                title = it.title ?: "",
                body = it.body ?: ""
            )
        }
}
