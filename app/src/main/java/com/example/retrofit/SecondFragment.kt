package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.FragmentFirstBinding
import com.example.retrofit.databinding.FragmentSecondBinding
import com.example.retrofit.model.RetrofitAdapter

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: TerraMarsViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedTerraMars.observe(viewLifecycleOwner, Observer {
            it?.let {
                Glide.with(binding.imageView).load(it.imgSrc).into(binding.imageView)
                binding.tvType.text = it.type
                binding.tvPrice.text = it.price.toString()
            }
        })
    }
}