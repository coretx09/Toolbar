package com.example.toolbar

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.toolbar.databinding.FragmentStartBinding


/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {


    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private var isVolume = true
    private var isAbout = true

    //private var drawerLayout: DrawerLayout? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val navController = findNavController()

//setOf(R.id.startFragment, R.id.settingFragment),

        val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)



        binding.startButton.setOnClickListener{goToNextFragment()}

        binding.toolbar.setOnMenuItemClickListener{
            when(it.itemId) {
                R.id.volume -> {
                   isVolume = !isVolume
                    updateToolBar()
                    true
                }
                R.id.about -> {
                    goToNextFragment()
                    true
                }

                else -> false
            }
        }

        //binding.Toolbar.inflateMenu(R.menu.toolbar_menu)

    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    fun goToNextFragment(){
        //R.id.action_startFragment_to_nextFragment
        findNavController().navigate(StartFragmentDirections.actionStartFragmentToNextFragment("starter/about"))
    }

    fun updateToolBar() {
        val volumeIcon = binding.toolbar.menu.findItem(R.id.volume)
        volumeIcon.icon =
            if (isVolume)
                // get drawlabe by contextcompat
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_baseline_volume_up_24)
        //else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_baseline_volume_off_24)
        // get drawlable by Resourse compat
        else ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_volume_off_24, null)

    }



}