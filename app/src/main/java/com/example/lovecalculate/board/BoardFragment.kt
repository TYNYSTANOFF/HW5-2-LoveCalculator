package com.example.lovecalculate.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.Prefs
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentBoardBinding
import com.example.lovecalculate.databinding.ItemBoardBinding


class BoardFragment : Fragment() {

    lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter(requireContext(), findNavController())
        binding.view.adapter = adapter
        binding.dots.setViewPager2(binding.view)
        binding.dots.setViewPager2(binding.view)
        binding.tvNext.setOnClickListener {
            Prefs(requireContext()).saveState()
            findNavController().navigate(R.id.homeFragment)
        }
    }
}