package com.lucasfagundes.roga_labs.feature.posts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasfagundes.roga_labs.feature.posts.data_remote.data_source.PostRemoteDataSource
import com.lucasfagundes.roga_labs.feature.posts.data_remote.model.CommentResponse
import com.lucasfagundes.roga_labs.feature.posts.data_remote.model.PostResponse
import com.lucasfagundes.roga_labs.feature.posts.presentation.mapper.CommentMapper
import com.lucasfagundes.roga_labs.feature.posts.presentation.mapper.PostMapper
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.CommentModel
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.PostModel
import com.lucasfagundes.roga_labs.feature.posts.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(private val postRemoteDataSource: PostRemoteDataSource) : ViewModel() {

    val postList: MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val commentList: MutableLiveData<List<CommentModel>> by lazy {
        MutableLiveData<List<CommentModel>>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        getPostsVM()
    }

    private fun getPostsVM() {
        postRemoteDataSource.getPostsFromSource().enqueue(
            object : Callback<List<PostResponse>> {
                override fun onResponse(call: Call<List<PostResponse>>, response: Response<List<PostResponse>>
                ) {
                    postList.value = PostMapper.toPresentation(response.body())
                }

                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    error.value = Constants.ERROR
                }
            }
        )
    }

    private fun getCommentsVM(postId:Int) {
        postRemoteDataSource.getCommentsFromSource(postId).enqueue(
            object : Callback<List<CommentResponse>> {
                override fun onResponse(
                    call: Call<List<CommentResponse>>,
                    response: Response<List<CommentResponse>>
                ) {
                    commentList.value = CommentMapper.toPresentation(response.body())
                }
                override fun onFailure(call: Call<List<CommentResponse>>, t: Throwable) {
                    error.value = Constants.ERROR
                }

            }
        )
    }
}