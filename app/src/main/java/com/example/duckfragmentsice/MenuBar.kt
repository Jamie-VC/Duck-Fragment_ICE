package com.example.duckfragmentsice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val CleanFrag = CleaningFragment()
private  val FeedFrag = FeedingFragment()
private val PlayFrag = PlayingFragment()

class MenuBar : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(PlayFrag)
        val bottomBar = findViewById<BottomNavigationView>(R.id.navBar)
        bottomBar.setOnItemSelectedListener{
            when (it.itemId)
            {
                R.id.ic_feed->replaceFrag(FeedFrag)
                R.id.ic_play->replaceFrag(PlayFrag)
                R.id.ic_clean->replaceFrag(CleanFrag)
            }
            true
        }
    }
    private fun replaceFrag(fragment: Fragment)
    {
        if(fragment!=null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayout,fragment)
            transaction.commit()
        }
    }
}