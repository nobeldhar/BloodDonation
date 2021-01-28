package com.nobeldhar.blooddonation.ui.profile.settings.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.remote.requests.SettingsRequest
import com.nobeldhar.blooddonation.data.remote.responses.AuthResponse
import com.nobeldhar.blooddonation.data.repository.SettingsRepository
import com.nobeldhar.blooddonation.utils.Resource
import com.nobeldhar.blooddonation.utils.SharedPrefsHelper
import javax.inject.Inject

class
BasicViewModel
@Inject constructor(
        val settingsRepository: SettingsRepository,
        val prefsHelper: SharedPrefsHelper
) : ViewModel() {
    var name: String = prefsHelper.getUser()?.name.toString()
    var email: String = prefsHelper.getUser()?.email.toString()
    var phone: String? = null

    val ui = MutableLiveData<String>()

    fun onUpdateClicked(){
        ui.value = "Clicked"
    }

    fun update(): LiveData<Resource<AuthResponse>> {
        val settingsRequest = SettingsRequest(name = name, email = email)
        return settingsRepository.updateBasicInfo(settingsRequest)
    }
}