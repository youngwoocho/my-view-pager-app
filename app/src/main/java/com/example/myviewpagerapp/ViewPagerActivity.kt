package com.example.myviewpagerapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myviewpagerapp.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityViewPagerBinding::inflate)

    private val viewPagerCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            updateProgressBar(position)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.buttonViewpagerNextScreen.setOnClickListener {
            moveForwardViewPager()
        }

        viewBinding.viewpager.adapter = ScreenSlidePagerAdapter(this)

        viewBinding.viewpager.registerOnPageChangeCallback(viewPagerCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding.viewpager.unregisterOnPageChangeCallback(viewPagerCallback)
        Log.d(TAG, "unregistered viewPager callback")
    }

    override fun onBackPressed() {
        moveBackViewPager()
    }

    private fun moveBackViewPager() {
        with(viewBinding) {
            when (viewpager.currentItem) {
                0 -> super.onBackPressed()
                else -> {
                    viewpager.currentItem = viewpager.currentItem - 1
                }
            }
        }
    }

    private fun moveForwardViewPager() {
        with(viewBinding) {
            when (viewpager.currentItem) {
                NUM_PAGES - 1 -> goToExitActivity()
                else -> {
                    viewpager.currentItem = viewpager.currentItem + 1
                }
            }
        }
    }

    private fun goToExitActivity() {
        startActivity(Intent(this, ExitActivity::class.java))
    }

    private fun updateProgressBar(itemPosition: Int) {
        viewBinding.progressbar.progress = (itemPosition + 1) * 100 / NUM_PAGES
    }

    companion object {
        const val NUM_PAGES = 3
        private const val TAG = "ViewPagerActivity"
    }
}