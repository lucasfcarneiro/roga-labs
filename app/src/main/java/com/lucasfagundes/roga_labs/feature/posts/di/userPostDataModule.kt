package com.lucasfagundes.roga_labs.feature.posts.di

import com.lucasfagundes.roga_labs.feature.posts.data_source.PostRemoteDataSource
import com.lucasfagundes.roga_labs.feature.posts.data_source.service.PostService
import com.lucasfagundes.roga_labs.feature.posts.network.WebServiceFactory
import com.lucasfagundes.roga_labs.feature.posts.utils.Constants
import org.koin.dsl.module

val postDataModule = module {

    single { WebServiceFactory.getRetrofitInstance(Constants.BASE_URL) as PostService }

    factory { PostRemoteDataSource(service = get()) }
}