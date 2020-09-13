package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navigation.fragments.DashboardFragment
import com.example.navigation.fragments.FavoritesFragment
import com.example.navigation.fragments.HomeFragment
import com.example.navigation.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homefragment = HomeFragment()
        val favoritesFragment = FavoritesFragment()
        val settingsFragment = SettingsFragment()
        val dashboardFragment = DashboardFragment()

        makeCurrentFragment(homefragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homefragment)
                R.id.ic_favorite -> makeCurrentFragment(favoritesFragment)
                R.id.ic_setting -> makeCurrentFragment(settingsFragment)
                R.id.ic_dashboard -> makeCurrentFragment(dashboardFragment)

                /**
                 * eikhan R.id.dashboard die ami muloto navigation relation koreci
                 * tutorial link:
                 * https://drive.google.com/file/d/1kGC3yvqWi8btq-ZA5aMvhOSIKp9LIITk/view?usp=sharing
                 */
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }



    }
