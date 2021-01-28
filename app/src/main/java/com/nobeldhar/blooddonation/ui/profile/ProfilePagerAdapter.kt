package com.nobeldhar.blooddonation.ui.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nobeldhar.blooddonation.ui.profile.donatehistory.DonateHistoryFragment
import com.nobeldhar.blooddonation.ui.profile.settings.SettingsFragment
import com.nobeldhar.blooddonation.ui.profile.timeline.TimelineFragment

class ProfilePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TimelineFragment()
            1 -> DonateHistoryFragment()
            2 -> SettingsFragment()
            else -> TimelineFragment()
        }
    }
}