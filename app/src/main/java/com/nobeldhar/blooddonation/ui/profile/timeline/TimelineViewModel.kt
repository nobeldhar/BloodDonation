package com.nobeldhar.blooddonation.ui.profile.timeline

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.local.entities.TimeLinePost
import com.nobeldhar.blooddonation.data.remote.responses.AuthResponse
import com.nobeldhar.blooddonation.data.repository.ProfileRepository
import com.nobeldhar.blooddonation.utils.Resource
import javax.inject.Inject

class
TimelineViewModel
@Inject constructor(
        val profileRepository: ProfileRepository
): ViewModel() {

    fun getTimeLinePosts(): LiveData<Resource<List<TimeLinePost>>> {
        return profileRepository.getTimeLinePosts()
    }

    fun likePost(post: TimeLinePost): LiveData<Resource<AuthResponse>> {
        return profileRepository.likePost(post.id)
    }
}