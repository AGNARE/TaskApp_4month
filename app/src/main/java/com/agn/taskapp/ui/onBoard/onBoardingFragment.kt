package com.agn.taskapp.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.agn.taskapp.data.local.Pref
import com.agn.taskapp.databinding.FragmentOnBoardingBinding
import com.agn.taskapp.model.OnBoard
import com.agn.taskapp.ui.onBoard.adapter.OnBoardingAdapter

class onBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        val adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter = adapter

        // add circleIndicator
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    fun onClick(onBoard: OnBoard) {
        findNavController().navigateUp()
        pref.saveUserSeen()
    }
}