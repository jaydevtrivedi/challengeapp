package com.companyname.challengeapp.ui.PrimaryScreen

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.companyname.challengeapp.R
import com.companyname.challengeapp.databinding.PrimaryScreenFragmentBinding
import com.companyname.challengeapp.utils.MenuFilter
import com.companyname.challengeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrimaryScreen : Fragment(), MovieListAdapter.ItemClickListener {

    lateinit var binding: PrimaryScreenFragmentBinding
    val viewModel: PrimaryScreenViewModel by viewModels()
    lateinit var adapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PrimaryScreenFragmentBinding.inflate(inflater)
        setHasOptionsMenu(true)
        setupRecyclerView()
        setupObservers()
        return binding.root
    }

    fun setupRecyclerView() {
        adapter = MovieListAdapter(this)
        binding.moviesRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.moviesRecyclerView.adapter = adapter
    }

    fun setupObservers() {
        viewModel.baseData.observe(viewLifecycleOwner, Observer { it: Resource ->
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (it.data != null) {
                        adapter.setItems(it.data.Movies)
                    }
                }

                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData(MenuFilter.CINEMA_WORLD)
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_filter, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Updates the filter in the [OverviewViewModel] when the menu items are selected from the
     * overflow menu.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.getData(
            when (item.itemId) {
                R.id.cinemaworld -> MenuFilter.CINEMA_WORLD
                R.id.filmworld -> MenuFilter.FILM_WORLD
                else -> MenuFilter.CINEMA_WORLD
            }
        )
        return true
    }

    override fun onClickedEntitlement(id: String) {
        findNavController().navigate(
            R.id.action_primaryScreen_to_secondaryFragment,
            bundleOf(
                "id" to id
            )
        )
    }

}