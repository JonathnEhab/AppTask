package com.exmaple.task.ui.repo

import com.exmaple.task.ui.data_source.network.ApiService
import com.exmaple.task.ui.datamodel.Post

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }

    override suspend fun PostsDetalis(id :String): Post {
       return apiService.getPostDetails(id)
    }

}