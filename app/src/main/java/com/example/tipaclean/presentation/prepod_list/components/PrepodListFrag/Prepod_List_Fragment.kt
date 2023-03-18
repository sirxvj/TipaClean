package com.example.tipaclean.presentation.prepod_list.components.PrepodListFrag

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AlertDialog
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tipaclean.R
import dagger.hilt.android.AndroidEntryPoint


class Prepod_List_Fragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PrepodListAdapter
    lateinit var sercher: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(PrepodListViewModel::class.java)
        val v = inflater.inflate(R.layout.fragment_prepod__list_, container, false)
        viewModel.context = this.requireContext()
        recyclerView = v.findViewById(R.id.rv_main)
        adapter = PrepodListAdapter(this.requireContext())
        //sercher = v.findViewById(R.id.serch)
        recyclerView.adapter = adapter
        viewModel.state.observe(viewLifecycleOwner, { state ->
            state.let { adapter.setList(state.prepods) }
        })

        return v
    }
}
