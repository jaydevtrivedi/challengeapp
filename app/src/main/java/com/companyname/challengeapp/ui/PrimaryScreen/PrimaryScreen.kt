package com.companyname.challengeapp.ui.PrimaryScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.companyname.challengeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrimaryScreen : Fragment() {

    companion object {
        fun newInstance() = PrimaryScreen()
    }

    private lateinit var viewModel: PrimaryScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.primary_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrimaryScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}