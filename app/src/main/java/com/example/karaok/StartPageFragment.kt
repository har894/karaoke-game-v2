package com.example.karaok

import android.R.attr.defaultValue
import android.R.attr.key
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class StartPageFragment : Fragment() {
     var firstTeamName: String="hkjhkjh"
     var secondTeamName: String="huhui"
    var duration: Int = 0
    var point: Int = 0
    var pPoint: Int = 0
    var isFirst: Boolean = true
    var firstTeamPoints: Int = 0
    var secondTeamPoints: Int = 0
    lateinit var teamName: String
    lateinit var gameScore: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_page, container, false)
        view.findViewById<Button>(R.id.startButton).setOnClickListener {

            if (isFirst) {
                teamName = firstTeamName
                isFirst = false
            } else {
                teamName = secondTeamName
                isFirst = true
            }
            (activity as AppCompatActivity).addFragment(
                RoundPageFragment.newInstance(
                    this,
                    duration,
                    pPoint,
                    point,
                    teamName
                )
            )
        }
       val f= view.findViewById<TextView>(R.id.currentTeamName)
        f.text = teamName
        gameScore = view.findViewById<TextView>(R.id.gameScore)
        val bundle = this.arguments
        if (bundle != null) {
            if (firstTeamName.equals(bundle.getString("currentTeamName"))) {
                firstTeamPoints = firstTeamPoints + bundle.getInt("roundPoint", defaultValue)
            } else {
                secondTeamPoints = secondTeamPoints + bundle.getInt("roundPoint", defaultValue)
            }
        }
        gameScore.text = "${firstTeamName} (${firstTeamPoints} ։${secondTeamPoints}) ${secondTeamName}"
        return view
    }

    companion object {

        fun newInstance(
            firstTeamName: String,
            secondTeamName: String,
            duration: Int,
            point: Int,
            pPoint: Int
        ): Fragment {

            val fragment = StartPageFragment()
            fragment.duration = duration
            fragment.firstTeamName = firstTeamName
            fragment.pPoint = pPoint
            fragment.point = point
            fragment.secondTeamName = secondTeamName
            fragment.teamName=firstTeamName
            return fragment
        }


    }
}