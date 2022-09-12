package com.example.lovecalculate.fragment.history

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.BaseFragment
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentHistoryBinding
import com.example.lovecalculate.ui.App

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun inflate(): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeHistory()
    }

    private fun observeHistory() {
        App.dp.historyDao().sort().observe(viewLifecycleOwner){ data->
            Log.e("ololo", "onViewCreated$data")
            adapter = HistoryAdapter(data)
            binding.recyclerView.adapter = this.adapter

            rename()
        }

    }

    private fun rename() {
        adapter.onClick = {
            val bundle  = Bundle()
            bundle.putString("key1", it.firstName)
            findNavController().navigate(R.id.homeFragment, bundle)
        }
    }

}