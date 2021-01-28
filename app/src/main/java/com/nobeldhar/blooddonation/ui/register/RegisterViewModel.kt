package com.nobeldhar.blooddonation.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nobeldhar.blooddonation.data.remote.requests.AuthRequest
import com.nobeldhar.blooddonation.data.repository.AuthRepository
import com.nobeldhar.blooddonation.utils.Validator
import javax.inject.Inject

class
RegisterViewModel
@Inject constructor(
    val authRepository: AuthRepository
) : ViewModel() {

    var name: String = ""
    var email: String = ""
    var phone: String = ""
    var pass: String = ""
    var confirm_pass: String = ""


    val _registerInfo = MutableLiveData<AuthRequest>()
    var _errorUiRegister = MutableLiveData<String>()

    val getRegisterResult = Transformations.switchMap(_registerInfo) {
        authRepository.registerUser(it)
    }

    fun onRegisterClicked() {

        if (name.isBlank()) {
            _errorUiRegister.value = "Empty Phone Number!"
        } else if (email.isBlank()) {
            _errorUiRegister.value = "Empty Email!"
        } else if (phone.isBlank()) {
            _errorUiRegister.value = "Empty Phone Number!"
        } else if (pass.isBlank()) {
            _errorUiRegister.value = "Empty Password!"
        } else if (confirm_pass.isBlank()) {
            _errorUiRegister.value = "Empty Confirm Password!"
        } else if ((pass.length < 4)) {
            _errorUiRegister.value = "Minimum Password Length is 4 ! "
        } else if ((pass != confirm_pass)) {
            _errorUiRegister.value = "Confirm Password Mismatched!"
        } else if (!Validator.validatePhone(phone)) {
            _errorUiRegister.value = "Not a Valid Phone Number! "
        } else if (!Validator.validateEmail(email)) {
            _errorUiRegister.value = "Not a Valid Email! "
        } else {
            val request = AuthRequest(
                name = name, phone = phone, email = email,
                pass = pass, password_confirmation = confirm_pass
            )

            _registerInfo.value = request
        }
    }

    companion object {
        private const val TAG = "RegisterViewModel"
    }
}