package com.example.myviewpagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myviewpagerapp.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityViewPagerBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.buttonViewpagerNextScreen.setOnClickListener {
            startActivity(Intent(this, ExitActivity::class.java))
        }
    }
}