package com.nobeldhar.blooddonation.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nobeldhar.blooddonation.ui.dashboard.allposts.AllPostsFragment
import com.nobeldhar.blooddonation.ui.dashboard.members.MembersFragment
import com.nobeldhar.blooddonation.ui.dashboard.topdoner.TopDonorsFragment
import com.nobeldhar.blooddonation.ui.dashboard.group.GroupFragment

class DashboardPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllPostsFragment()
            1 -> MembersFragment()
            2 -> GroupFragment()
            3 -> TopDonorsFragment()
            else -> AllPostsFragment()
        }
    }
}