package com.companyname.challengeapp.ui.PrimaryScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.companyname.challengeapp.R
import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.databinding.PrimaryScreenFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrimaryScreen : Fragment() {

    private lateinit var binding: PrimaryScreenFragmentBinding
    private val viewModel: PrimaryScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PrimaryScreenFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        viewModel.baseData.observe(viewLifecycleOwner, Observer {
            binding.cinemaName.text = it.Provider
        })
    }

}