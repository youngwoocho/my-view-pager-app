package com.example.myviewpagerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myviewpagerapp.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityEntryBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.buttonNextScreen.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
    }
}