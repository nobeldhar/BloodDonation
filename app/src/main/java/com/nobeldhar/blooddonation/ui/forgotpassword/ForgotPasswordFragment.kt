package com.nobeldhar.blooddonation.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ForgotPasswordFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by viewModels<ForgotPasswordViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}