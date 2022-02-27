package com.example.myviewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myviewpagerapp.databinding.ActivityExitBinding

class ExitActivity : AppCompatActivity() {
    private val viewBinding by viewBindingDelegate(ActivityExitBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolBarExit)
        viewBinding.toolBarExit.navigationIcon =
            ContextCompat.getDrawable(this, R.drawable.back_arrow)
        viewBinding.toolBarExit.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}