package com.exmaple.task.ui.repo

import com.exmaple.task.ui.datamodel.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun PostsDetalis(id:String ) :Post
}