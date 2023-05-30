package com.ikabanov.letsbuyremaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ikabanov.letsbuyremaster.databinding.ActivityMainBinding
import com.ikabanov.letsbuyremaster.databinding.FragmentProductsBinding


class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host)


        /*val binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment = binding.navHost
        navController = navHostFragment.findNavController()*/
    }
}