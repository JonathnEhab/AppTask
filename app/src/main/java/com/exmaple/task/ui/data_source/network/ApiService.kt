package com.exmaple.task.ui.data_source.network

import com.exmaple.task.ui.datamodel.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
    @GET("posts/{postId}")
    suspend fun getPostDetails(@Path("postId") postId: String): Post
}
