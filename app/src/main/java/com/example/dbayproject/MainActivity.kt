package com.example.dbayproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.dbayproject.databinding.ActivityMainBinding
import com.example.dbayproject.login.presenter.LogInPresenter
import com.example.dbayproject.mainCategory.presenter.CatPresenter
import com.example.dbayproject.mainCategory.ui.CategoryFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var actionBarToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Fragment of all Categories
        addFragment(CategoryFragment())


        val sharedPreferences = getSharedPreferences("LoginSP", Context.MODE_PRIVATE)

//        binding.uservalue.text =
//            "Welcome to home " + sharedPreferences.getString("firstName", "Default")
        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarToggle)

        actionBarToggle.isDrawerIndicatorEnabled = false
        binding.toolbar.setNavigationIcon(R.drawable.ic_home)
        binding.toolbar.setNavigationOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        actionBarToggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isCheckable = true
            binding.drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.shoppingcart -> {
//                    startActivity(Intent(this, CartActivity::class.java))
                }
                R.id.profile -> {
//                    startActivity(Intent(this, ProfileActivity::class.java))
                }
                R.id.shop -> {
                    Toast.makeText(this, "I am SHOP", Toast.LENGTH_SHORT).show()
                }
                R.id.orderhistory -> {
                    Toast.makeText(this, "I am OrderHistory", Toast.LENGTH_SHORT).show()
                }
                R.id.logout -> {
                    Toast.makeText(this, "I am Logout", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shoppingcart -> {
//                    startActivity(Intent(this, CartActivity::class.java))
                return true
            }
            R.id.profile -> {
//                    startActivity(Intent(this, ProfileActivity::class.java))
                return true
            }
            R.id.shop -> {
                Toast.makeText(this, "I am SHOP", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.orderhistory -> {
                Toast.makeText(this, "I am OrderHistory", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.logout -> {
                Toast.makeText(this, "I am Logout", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return false
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navView)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun AppCompatActivity.addFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.addToBackStack(Tag)
        transaction.commit()
    }

    companion object{
        const val Tag = "FIRST"
    }
}