package com.companyname.challengeapp.ui.SecondaryScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.companyname.challengeapp.databinding.SecondaryFragmentBinding
import com.companyname.challengeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondaryScreen : Fragment() {

    lateinit var binding: SecondaryFragmentBinding
    private val viewModel: SecondaryScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondaryFragmentBinding.inflate(inflater)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id")
        if (!id.isNullOrEmpty()) {
            showLoading()
            hideUIElements()
            viewModel.getData(id)
        } else {
            showError(id)
        }
    }

    fun setupObservers() {
        viewModel.baseData.observe(viewLifecycleOwner, Observer { it: Resource ->
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (it.movie != null) {
                        showUIElements()
                        Glide.with(binding.root)
                            .load(it.movie.Poster)
                            .apply(RequestOptions.overrideOf(450, 450))
                            .into(binding.image)

                        binding.movieName.text = it.movie.Title
                        binding.providername.text = viewModel.getProviderName(it.movie.ID)
                        binding.movieprice.text = it.movie.Price.toString()
                    }
                }

                Resource.Status.ERROR -> {
                    showError(it.message)
                }

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    fun hideUIElements() {
        binding.image.visibility = View.GONE
        binding.providername.visibility = View.GONE
        binding.movieprice.visibility = View.GONE
    }

    fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun showUIElements() {
        binding.progressBar.visibility = View.GONE
        binding.image.visibility = View.VISIBLE
        binding.movieName.visibility = View.VISIBLE
        binding.providername.visibility = View.VISIBLE
        binding.movieprice.visibility = View.VISIBLE
    }

    fun showError(message: String?) {
        val defaultError = "Something went wrong! Please contact support."
        hideUIElements()
        binding.progressBar.visibility = View.GONE
        binding.movieName.text = if (!message.isNullOrEmpty()) message else defaultError
    }
}