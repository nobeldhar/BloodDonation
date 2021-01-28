package com.nobeldhar.blooddonation.ui.dashboard.allposts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.local.entities.Post
import com.nobeldhar.blooddonation.data.remote.responses.AuthResponse
import com.nobeldhar.blooddonation.data.repository.DashboardRepository
import com.nobeldhar.blooddonation.utils.Resource
import javax.inject.Inject

class
AllPostsViewModel
@Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    fun getPosts(): LiveData<Resource<List<Post>>> {
        return dashboardRepository.getPosts()
    }

    fun likePost(post: Post): LiveData<Resource<AuthResponse>> {
        return dashboardRepository.likePost(post.id)
    }
}