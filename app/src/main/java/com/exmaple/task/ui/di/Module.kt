package com.exmaple.task.ui.di

import android.content.Context

import com.exmaple.task.ui.data_source.network.ApiService
import com.exmaple.task.ui.repo.PostRepository
import com.exmaple.task.ui.repo.PostRepositoryImpl
import com.exmaple.task.ui.toast.ToastHelper
import com.exmaple.task.ui.toast.ToastHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(apiService: ApiService): PostRepository {
        return PostRepositoryImpl(apiService)
    }
    @Provides
    @Singleton
    fun provideToastHelper(@ApplicationContext context: Context): ToastHelper {
        return ToastHelperImpl(context)
    }
}




