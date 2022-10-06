package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.test.databinding.ActivityMainBinding
import com.example.test.fragments.ArticlesFragment
import com.example.test.fragments.JournalFragment
import com.example.test.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val articlesFragment = ArticlesFragment()
        val journalFragment = JournalFragment()
        val profileFragment = ProfileFragment()
         replaceFragment(journalFragment)
      //  val navHastFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
       //navController= navHastFragment.navController
       // setupWithNavController(binding.bottomNavigetion, navController)

     binding.apply {
         bottomNavigetion.setOnNavigationItemSelectedListener { it->
              when(it.itemId){
                  R.id.page_1 -> replaceFragment(journalFragment)
                  R.id.page_2 -> replaceFragment(articlesFragment)
                  R.id.page_3 -> replaceFragment(profileFragment)
              }
             true

            }

      }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()
        fragmentTrasaction.replace(R.id.frame_layout, fragment)
        fragmentTrasaction.commit()


    }
}