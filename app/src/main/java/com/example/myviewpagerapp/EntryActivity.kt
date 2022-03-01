package com.example.myviewpagerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.myviewpagerapp.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityEntryBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolBarEntry)

        viewBinding.buttonNextScreen.setOnClickListener {
            val animationBundle = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
               R.anim.slide_out_left
            ).toBundle()
            startActivity(Intent(this, ViewPagerActivity::class.java), animationBundle)
        }
    }
}