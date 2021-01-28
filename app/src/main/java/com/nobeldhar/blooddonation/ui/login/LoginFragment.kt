package com.nobeldhar.blooddonation.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.databinding.FragmentLoginBinding
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import com.nobeldhar.blooddonation.utils.Resource
import com.nobeldhar.blooddonation.utils.ViewUtils
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.fragment = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLoginResult.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progressVisibility(View.GONE)
                    val response = it.data
                    if (response != null) {
                        if (response.code == 200 && response.status) {
                            if(response.data.isVerified == 0){
                                val action = LoginFragmentDirections.actionNavLoginToNavVerifyCode()
                                findNavController().navigate(action)
                            }else{
                                val action = LoginFragmentDirections.actionNavLoginToNavHome()
                                findNavController().navigate(action)
                            }
                        } else {
                            val message = response.messages.toString()
                            Log.d(TAG, "onViewCreated: failed $message")
                            ViewUtils.toastFailedWithMessage(requireActivity(), requireContext(), message)
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    progressVisibility(View.GONE)
                    Log.d(Companion.TAG, "onActivityCreated: error " + it.isNetworkError)
                    it.isNetworkError?.let { it ->
                        if (it) {
                            ViewUtils.toastNoInternet(requireActivity(), requireContext())
                        }
                    }
                }
                Resource.Status.LOADING ->
                    progressVisibility(View.VISIBLE)
            }
        })

        viewModel._errorUiLogin.observe(viewLifecycleOwner, {
            ViewUtils.toastFailedWithMessage(requireActivity(), requireContext(), it)
        })
    }

    private fun progressVisibility(visible: Int) {
        binding.pbLogin.visibility = visible
    }

    fun onRegisterClicked() {
        val action = LoginFragmentDirections.actionNavLoginToNavRegister()
        findNavController().navigate(action)
    }

    fun onForgotPassClicked(){
        findNavController().navigate(LoginFragmentDirections.actionNavLoginToNavForgotPassword())
    }



    companion object {
        private const val TAG = "LoginFragment"
    }
}