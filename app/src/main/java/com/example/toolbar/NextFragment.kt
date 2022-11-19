package com.example.toolbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toolbar.databinding.FragmentNextBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NextFragment : Fragment() {

    private var _binding: FragmentNextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNextBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}