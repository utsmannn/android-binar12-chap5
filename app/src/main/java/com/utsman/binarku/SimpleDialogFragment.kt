package com.utsman.binarku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.utsman.binarku.databinding.DialogFragmentSimpleBinding

class SimpleDialogFragment : DialogFragment() {

    private var _binding: DialogFragmentSimpleBinding? = null
    private val binding: DialogFragmentSimpleBinding
        get() = _binding!!

    override fun onStart() {
        super.onStart()
        val width = 800
        val height = 900
        dialog?.window?.setLayout(width, height)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogFragmentSimpleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCloseFragment.setOnClickListener {
            dismiss()
        }
    }
}