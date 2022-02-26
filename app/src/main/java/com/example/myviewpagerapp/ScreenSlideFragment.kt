package com.example.myviewpagerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myviewpagerapp.databinding.FragmentScreenSlideBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ScreenSlideFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScreenSlideFragment(private val position: Int) : Fragment() {

    private val viewBinding by viewBindingDelegate(FragmentScreenSlideBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.textviewIndicator.text = getString(R.string.textview_indicator, position)
    }
}