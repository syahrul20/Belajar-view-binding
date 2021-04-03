package com.sf.viewbindingapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sf.viewbindingapp.databinding.FragmentSampleWithoutViewBindingBinding

class SampleViewBindingWithoutBaseClassFragment : Fragment() {

    private var _binding: FragmentSampleWithoutViewBindingBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = SampleViewBindingWithoutBaseClassFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSampleWithoutViewBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}