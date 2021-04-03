package com.sf.viewbindingapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sf.viewbindingapp.databinding.FragmentSampleBinding
import com.sf.viewbindingapp.utils.BaseFragmentBinding

class SampleFragment : BaseFragmentBinding<FragmentSampleBinding>() {

    private lateinit var pageViewModel: PageViewModel

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int): SampleFragment {
            return SampleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSampleBinding
        get() = FragmentSampleBinding::inflate

    override fun setupView(binding: FragmentSampleBinding) {
        pageViewModel.text.observe(this, {
            binding.sectionLabel.text = it
        })
    }
}