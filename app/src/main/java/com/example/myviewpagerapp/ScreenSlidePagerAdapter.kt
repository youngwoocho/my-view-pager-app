package com.example.myviewpagerapp

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(activity: AppCompatActivity) :FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = ViewPagerActivity.NUM_PAGES

    override fun createFragment(position: Int): Fragment = ScreenSlideFragment(position)
}