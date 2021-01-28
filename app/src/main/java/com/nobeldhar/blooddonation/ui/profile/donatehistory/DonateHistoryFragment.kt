package com.nobeldhar.blooddonation.ui.profile.donatehistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.factory.AppViewModelFactory
import com.nobeldhar.blooddonation.utils.SharedPrefsHelper
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DonateHistoryFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel: DonateHistoryViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var prefsHelper: SharedPrefsHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_donate_history, container, false)
    }



}