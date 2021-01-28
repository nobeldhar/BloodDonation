package com.nobeldhar.blooddonation.data.remote.sources

import com.nobeldhar.blooddonation.data.remote.requests.AuthRequest
import com.nobeldhar.blooddonation.data.remote.services.AuthService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRemoteDataSource @Inject constructor(
    private val authService: AuthService
): BaseDataSource() {
    suspend fun loginUser(authRequest: AuthRequest)
            = getResult { authService.loginUser(authRequest) }

    suspend fun logoutUser()
            = getResult { authService.logoutUser() }

    suspend fun registerUser(authRequest: AuthRequest)
            = getResult { authService.registerUser(authRequest) }

    suspend fun verifyOTPCode(authRequest: AuthRequest)
            = getResult { authService.verifyCode(authRequest) }

    suspend fun resendOTPCode()
            = getResult { authService.resendCode() }
}