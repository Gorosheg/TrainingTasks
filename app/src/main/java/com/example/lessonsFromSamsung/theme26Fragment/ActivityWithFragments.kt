package com.example.lessonsFromSamsung.theme26Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lessonsFromSamsung.R

open class ActivityWithFragments : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_26_fragments)

        val fragmentB = FragmentB()

        createFragmentB(fragmentB)
        initFragmentTextChangeListener(fragmentB)
    }

    private fun createFragmentB(fragment: Fragment) {
        supportFragmentManager.beginTransaction().run {
            add(R.id.frameLayout, fragment)
            commit()
        }
    }

    private fun initFragmentTextChangeListener(fragmentB: FragmentB) {
        val fragmentA: FragmentA? = supportFragmentManager.findFragmentById(R.id.fragmentA) as? FragmentA

        if (fragmentA != null) {
            fragmentA.fragmentTextChangeListener = fragmentB
        }
    }

}