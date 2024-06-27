package com.saman.aparat

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.saman.aparat.Activity.LoginActivity
import com.saman.aparat.Activity.SearchActivity
import com.saman.aparat.databinding.ActivityMainBinding
import com.saman.aparat.ui.main.adapter.TabsAdapter
import com.saman.aparat.ui.main.category.categoryFragment
import com.saman.aparat.ui.main.favorite.FavoriteFragment
import com.saman.aparat.ui.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    @SuppressLint("RtlHardcoded", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.navMenu.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.item_home -> {

                    binding.viewPager2.currentItem = 2
                    binding.navMenu.menu.findItem(R.id.item_home).isChecked = true

                }
                R.id.item_categories -> {
                    binding.viewPager2.currentItem = 1
                    binding.navMenu.menu.findItem(R.id.item_categories).isChecked = true
                }
                R.id.item_favorite -> {
                    binding.viewPager2.currentItem = 0
                    binding.navMenu.menu.findItem(R.id.item_favorite).isChecked = true
                }
            }

            false
        }

        binding.imgSearch.setOnClickListener {
            var intent=Intent(applicationContext, SearchActivity::class.java)
            startActivity(intent)
        }


        binding.navigationBar.setNavigationItemSelectedListener(OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main_page -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.profile->{
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                }


                R.id.exit -> {
                    val alertDialog = AlertDialog.Builder(this@MainActivity)
                    alertDialog.setTitle(R.string.exit)
                    alertDialog.setMessage("آیا میخواهید از برنامه خارج شوید؟")
                    alertDialog.setIcon(android.R.drawable.ic_delete)
                    alertDialog.setPositiveButton("خیر") { dialogInterface, i -> }
                    alertDialog.setNeutralButton("بله",
                        DialogInterface.OnClickListener { dialogInterface, i -> finishAffinity() })
                    alertDialog.show()
                }

                R.id.introduce -> {
                    val intent1 = Intent(Intent.ACTION_SEND)
                    intent1.type = "text/plain"
                    intent1.putExtra(Intent.EXTRA_SUBJECT, "share my message")
                    intent1.putExtra(Intent.EXTRA_TEXT, "share")
                    startActivity(Intent.createChooser(intent1, "share"))
                }
            }
            false
        })



/*  val toggle = ActionBarDrawerToggle(
            this@MainActivity, binding.drawer,
            binding.toolbar, R.string.open, R.string.close)
      window.decorView.layoutDirection=View.LAYOUT_DIRECTION_RTL


     toggle.syncState()*/

        val mSlideState:Boolean=false

    binding.imgMenu.setOnClickListener {
        if (mSlideState) {
            binding.drawer.closeDrawer(Gravity.RIGHT)
        } else {
            binding.drawer.openDrawer(Gravity.RIGHT)
        }
    }





    }


    override fun onResume() {
        super.onResume()

        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(FavoriteFragment())
        fragmentList.add(categoryFragment())
        fragmentList.add(HomeFragment())
        val adapter= TabsAdapter(this,fragmentList)
        binding.viewPager2.adapter = adapter
        binding.viewPager2.isUserInputEnabled = false
        binding.viewPager2.currentItem = 2
        binding.navMenu.menu.findItem(R.id.item_home).isChecked=true
    }
}

