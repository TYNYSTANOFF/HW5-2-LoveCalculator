package com.example.lovecalculate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lovecalculate.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    lateinit var bizz
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
//        val navView: BottomNavigationView = binding.navView
//
//        navController = findNavController(R.id.nav_host_fragment_activity_main)
//
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home,
//                R.id.navigation_dashboard,
//                R.id.navigation_notifications,
//                R.id.navigation_profile
//            )
//        )
//        }
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//
//        if (!Prefs(this).isShow()) {
//            navController.navigate(R.id.boardFragment)
//        }
//
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            val fragment = arrayListOf(
//                R.id.navigation_home,
//                R.id.navigation_dashboard,
//                R.id.navigation_notifications,
//                R.id.navigation_profile
//            )
//            if (fragment.contains(destination.id)) {
//                navView.visibility = View.VISIBLE
//            } else {
//                navView.visibility = View.GONE
//            }
//
//            if (destination.id == R.id.boardFragment) {
//                supportActionBar?.hide()
//            } else {
//                supportActionBar?.show()
//            }
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//    }
//}
}}