package com.example.karaok

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.addFragment(fragment:Fragment){

    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
    transaction.replace(
        R.id.frame,
        fragment)
    transaction.setReorderingAllowed(true)
    transaction.addToBackStack("tag")
    transaction.commit()
}
