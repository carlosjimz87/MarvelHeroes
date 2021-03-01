package com.carlosjimz87.marvelheroes.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosjimz87.marvelheroes.R
import com.carlosjimz87.marvelheroes.databinding.ListFragmentBinding
import com.carlosjimz87.marvelheroes.models.Hero

class ListFragment(private var dummyHeroes: List<Hero>) : Fragment() {

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: ListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.list_fragment, container, false)
        initRecycler(binding)
        return binding.root
    }

    private fun initRecycler(binding: ListFragmentBinding) {
        binding.heroesRecyclerView.layoutManager = GridLayoutManager(context,1)
        binding.heroesRecyclerView.adapter = ListAdapter(dummyHeroes)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }


}