package com.lucasfagundes.roga_labs.feature.posts.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasfagundes.roga_labs.feature.posts.data_source.PostRemoteDataSource
import com.lucasfagundes.roga_labs.feature.posts.data_source.model.PostResponse
import com.lucasfagundes.roga_labs.feature.posts.presentation.model.PostModel
import com.lucasfagundes.roga_labs.feature.posts.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(private val postRemoteDataSource: PostRemoteDataSource) : ViewModel() {

    val postList: MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        getPosts()
    }

    private fun getPosts() {
        postRemoteDataSource.getPosts().enqueue(
            object : Callback<List<PostResponse>> {
                override fun onResponse(
                    call: Call<List<PostResponse>>,
                    response: Response<List<PostResponse>>
                ) {
                    postList.value = PostMapper.toPresentation(response.body())
                }

                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    error.value = Constants.ERROR
                }
            }
        )
    }
}