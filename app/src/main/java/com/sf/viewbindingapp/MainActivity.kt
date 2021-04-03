package com.sf.viewbindingapp

import android.content.Intent
import android.view.LayoutInflater
import com.sf.viewbindingapp.databinding.ActivityMainBinding
import com.sf.viewbindingapp.utils.BaseActivityBinding

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setUpView(binding: ActivityMainBinding) {
        binding.textView.text = "viewbinding dengan base class berhasil"
        binding.textView.setOnClickListener {
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
        }
    }
}