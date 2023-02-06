package com.utsman.binarku.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.utsman.binarku.*
import com.utsman.binarku.databinding.FragmentDogBinding

class DogFragment : Fragment() {

    private var _binding: FragmentDogBinding? = null
    private val binding: FragmentDogBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgDog.loadImageUrl(IMG_URL)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val IMG_URL = "https://www.ruparupa.com/blog/wp-content/uploads/2021/10/anjing-beagle.jpg"
    }
}