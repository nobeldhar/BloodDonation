package com.nobeldhar.blooddonation.ui.comments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.remote.responses.AuthResponse
import com.nobeldhar.blooddonation.data.remote.responses.CommentsResponse
import com.nobeldhar.blooddonation.data.repository.DashboardRepository
import com.nobeldhar.blooddonation.utils.Resource
import javax.inject.Inject

class
CommentsViewModel
@Inject constructor(
    val dashboardRepository: DashboardRepository
): ViewModel() {
    var comment: String? = null

    fun commentOnPost(postId:Int): LiveData<Resource<AuthResponse>>? {
        return comment?.let {
            Log.d(Companion.TAG, "commentOnPost: called")
            dashboardRepository.commentOnPost(it, postId) }
    }

    fun getComments(postId: Int): LiveData<Resource<CommentsResponse>> {
        return dashboardRepository.getComments(postId)
    }

    companion object {
        private const val TAG = "CommentsViewModel"
    }
}