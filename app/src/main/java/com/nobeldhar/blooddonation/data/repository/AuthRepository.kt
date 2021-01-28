package com.nobeldhar.blooddonation.data.repository

import com.nobeldhar.blooddonation.data.remote.requests.AuthRequest
import com.nobeldhar.blooddonation.data.remote.sources.AuthRemoteDataSource
import com.nobeldhar.blooddonation.utils.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val prefsHelper: SharedPrefsHelper
) {

    fun loginUser(authRequest: AuthRequest) = performAuthOperation(
            networkCall = { remoteDataSource.loginUser(authRequest) },
            saveAuthInfo = { prefsHelper.saveUser(it)}
    )

    fun logoutUser() = performAuthOperation(
            networkCall = { remoteDataSource.logoutUser() }
    )

    fun registerUser(authRequest: AuthRequest) = performAuthOperation(
            networkCall = { remoteDataSource.registerUser(authRequest) },
            saveAuthInfo = { prefsHelper.saveUser(it) }
    )

    fun verifyOTPCode(authRequest: AuthRequest) = performAuthOperation (
            networkCall = {remoteDataSource.verifyOTPCode(authRequest)}
    )

    fun resendOTPCode() = performAuthOperation (
            networkCall = {remoteDataSource.resendOTPCode()}
    )

    companion object {
        private const val TAG = "AuthRepository"
    }


}
