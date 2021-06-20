package com.example.lessonsFromSamsung.theme26Fragment

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.lessonsFromSamsung.R

open class ActivityWithFragments : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_26_fragments)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentTransaction.add(R.id.frameLayout, fragmentB)
        fragmentTransaction.commit()
      /*  val fragmentA = FragmentA()
       fragmentTransaction.hide(fragmentA)*/
    }
}