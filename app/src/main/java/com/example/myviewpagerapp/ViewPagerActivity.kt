package com.example.myviewpagerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myviewpagerapp.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityViewPagerBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.buttonViewpagerNextScreen.setOnClickListener {
            moveForwardViewPager()
        }

        viewBinding.viewpager.adapter = ScreenSlidePagerAdapter(this)

        updateProgressBar()
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
                    updateProgressBar()
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
                    updateProgressBar()
                }
            }
        }
    }

    private fun goToExitActivity() {
        startActivity(Intent(this, ExitActivity::class.java))
    }

    private fun updateProgressBar() {
        with(viewBinding) {
            progressbar.progress = (viewpager.currentItem + 1) * 100 / NUM_PAGES
        }
    }

    companion object {
        const val NUM_PAGES = 3
    }
}