package com.example.dbayproject.shoppingcart.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbayproject.R
import com.example.dbayproject.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentCartBinding.inflate(inflater,container,false)
        binding.recyclerviewCart.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

}