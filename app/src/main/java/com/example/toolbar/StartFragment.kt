package com.example.toolbar

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.toolbar.databinding.FragmentStartBinding


/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {


    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.startButton.setOnClickListener{goToNextFragment()}

        //binding.Toolbar.inflateMenu(R.menu.toolbar_menu)

        //(activity as AppCompatActivity).setSupportActionBar(binding.Toolbar)

    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    fun goToNextFragment(){
        findNavController().navigate(R.id.action_startFragment_to_nextFragment)
    }
    


}