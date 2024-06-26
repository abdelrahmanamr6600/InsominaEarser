package com.marco.ensominaearser.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentsList:ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    private var fragmentList = fragmentsList
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}