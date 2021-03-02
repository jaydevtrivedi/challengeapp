package com.companyname.challengeapp.ui.SecondaryScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.companyname.challengeapp.R
import com.companyname.challengeapp.databinding.PrimaryScreenFragmentBinding
import com.companyname.challengeapp.databinding.SecondaryFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondaryScreen : Fragment() {

    lateinit var binding: SecondaryFragmentBinding
    private val viewModel: SecondaryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondaryFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.id.text = arguments?.getString("id")
    }

}