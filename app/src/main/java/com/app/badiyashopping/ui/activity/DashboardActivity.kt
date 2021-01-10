package com.app.badiyashopping.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.app.badiyashopping.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class DashboardActivity : AppCompatActivity() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        navController = findNavController(R.id.nav_host_fragment)
        bottomNavigation.setupWithNavController(navController!!)
        navController!!.addOnDestinationChangedListener { _controller: NavController, destination: NavDestination?, arguments: Bundle? ->
            if (_controller.currentDestination!!.id == R.id.homeFragment) {
                include.textViewToolbarTitle.text = resources.getText(R.string.menu_home)
            } else if (_controller.currentDestination!!.id == R.id.categoryFragment) {
                include.textViewToolbarTitle.text = resources.getText(R.string.category)
            } else if (_controller.currentDestination!!.id == R.id.cartFragment) {
                include.textViewToolbarTitle.text = resources.getText(R.string.cart)
            } else if (_controller.currentDestination!!.id == R.id.myOrdersFragment) {
                include.textViewToolbarTitle.text = resources.getText(R.string.menu_my_order)
            } else if (_controller.currentDestination!!.id == R.id.SettingsFragment) {
                include.textViewToolbarTitle.text = resources.getText(R.string.menu_settings)
            }
        }
    }
}