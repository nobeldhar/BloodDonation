package com.nobeldhar.blooddonation.ui.profile.settings.password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.remote.requests.SettingsRequest
import com.nobeldhar.blooddonation.data.remote.responses.AuthResponse
import com.nobeldhar.blooddonation.data.repository.SettingsRepository
import com.nobeldhar.blooddonation.utils.Resource
import javax.inject.Inject

class
PasswordViewModel
@Inject constructor(
        val settingsRepository: SettingsRepository
) : ViewModel() {
    var oldPassword: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null

    var showAlert = MutableLiveData<Boolean>()

    fun onUpdateClicked(){
        showAlert.value = true
    }

    fun update(): LiveData<Resource<AuthResponse>> {

        val settingsRequest = SettingsRequest(current_password = oldPassword, password = newPassword, password_confirmation = confirmPassword)
        return settingsRepository.updatePassword(settingsRequest)
    }
}