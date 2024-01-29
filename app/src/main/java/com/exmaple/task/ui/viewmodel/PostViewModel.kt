package com.exmaple.task.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exmaple.task.ui.datamodel.Post
import com.exmaple.task.ui.repo.PostRepository
import com.exmaple.task.ui.toast.ToastHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository,
                                        private val toastHelper: ToastHelper
) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    private val _postDetails=MutableLiveData<Post>()
    val  postDetails: LiveData<Post> get() = _postDetails

    fun getPosts() {
        viewModelScope.launch {
            try {
                val postsList = repository.getPosts()
                _posts.value = postsList

            } catch (e: Exception) {
                // Use toastHelper to show the message
                if (e is HttpException) {
                    val errorCode = e.code()
                    val errorMessage = "HTTP error $errorCode: ${e.message()}"
                    toastHelper.showToast(errorMessage)
                } else {
                    toastHelper.showToast("Check your internet connection")
                }
            }
        }
    }
    fun getPostDetails(postId: String) {
        viewModelScope.launch {
            try {
                _postDetails.value = repository.PostsDetalis(postId)
            } catch (e: Exception) {
                // Handle error
                if (e is HttpException) {
                    val errorCode = e.code()
                    val errorMessage = "HTTP error $errorCode: ${e.message()}"
                    toastHelper.showToast(errorMessage)
                } else {
                    toastHelper.showToast("Check your internet connection")
                }
            }
        }
    }
}