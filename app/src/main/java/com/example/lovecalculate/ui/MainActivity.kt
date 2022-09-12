package com.example.lovecalculate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lovecalculate.Prefs
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.secondFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        if (!Prefs(this).isShow()) {
            navController.navigate(R.id.boardFragment)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val fragment = arrayListOf(
                R.id.homeFragment,
                R.id.secondFragment,
            )
            if (fragment.contains(destination.id)) {
                navView.visibility = View.VISIBLE
            } else {
                navView.visibility = View.GONE
            }

            if (destination.id == R.id.boardFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }


    }
}