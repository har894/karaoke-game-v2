package com.example.karaok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(),ParamsListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(GeneratePageFragment.newInstance(this))
    }

    override fun generateGame(
        firstTeamName: String,
        secondTeamName: String,
        duration: Int,
        point: Int,
        pPoint: Int
    ) {
       val fragment= StartPageFragment.newInstance(firstTeamName,secondTeamName,duration,point,pPoint)
        addFragment(fragment)
    }

    override fun onBackPressed() {
        val fm=supportFragmentManager
        val entryCount=fm.backStackEntryCount
        if (entryCount>1){
            fm.popBackStack()
        }else {
        finish();
        }
    }
}