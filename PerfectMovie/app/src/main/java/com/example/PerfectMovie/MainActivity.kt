package com.example.bottomnav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav : NavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(NavigationView, nav)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        //NavigationView.setNavigationItemSelectedListener(this)

    }

    /*override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.blankFragment1 ->{
                if(Navigation.findNavController(this, R.id.nav_host_fragment).currentDestination?.label != "fragment_blank"){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_blankFragment22_to_blankFragment)
                }

                return true
            }

            R.id.blankFragment22 ->{
                if(Navigation.findNavController(this, R.id.nav_host_fragment).currentDestination?.label != "fragment_blank2"){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_blankFragment_to_blankFragment22)
                }

                return true
            }

            else ->{
                return super.onOptionsItemSelected(item)
            }

        }
    }*/
}