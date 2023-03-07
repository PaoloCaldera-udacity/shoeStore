package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*  OR, ALTERNATIVELY
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         */

        Timber.plant(Timber.DebugTree())

        // Do not show the "Up" navigation button for login and shoe-list fragment
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.loginFragment,
            R.id.shoeListFragment
        ).build()

        // Initialize the navigation controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Action bar controlled by the navigation controller
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Let the navController support the "Up" navigation
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
