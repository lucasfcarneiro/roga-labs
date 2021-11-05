package com.lucasfagundes.roga_labs.feature.posts.presentation.mapper

import com.lucasfagundes.roga_labs.feature.posts.data_remote.model.CommentResponse
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.CommentModel

object CommentMapper {
    fun toPresentation(commentResponseList: List<CommentResponse>?): List<CommentModel> {
        return if (commentResponseList.isNullOrEmpty()) {
            emptyList()
        } else {
            parseCommentaryList(commentResponseList)
        }
    }

    private fun parseCommentaryList(commentResponseList: List<CommentResponse>): List<CommentModel> =
        commentResponseList.map {
            CommentModel(
                postId = it.postId ?: 0,
                id = it.id ?: 0,
                name = it.name ?: "",
                email = it.email ?: "",
                body = it.body ?: ""
            )
        }
}
