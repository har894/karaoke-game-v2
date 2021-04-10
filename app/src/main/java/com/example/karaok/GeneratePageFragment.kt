package com.example.karaok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class GeneratePageFragment : Fragment() {

    var roudDuration: Int = 40
    var roudPoint: Int = 150
    var roudIncrementPoint: Int = 10
    val armenianCheckBoxTitle: String = "Հայկական"
    val russianCheckBoxTitle: String = "Ռուսական"
    val otherCheckBoxTitle: String = "Արտասահմանյան"
    lateinit var inputFirstTeam: EditText
    lateinit var inputSecondTeam: EditText
    lateinit var listener: ParamsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_generate_page, container, false)

        view.findViewById<TextView>(R.id.armenianCategory).setText(armenianCheckBoxTitle)
        view.findViewById<TextView>(R.id.russianCategory).setText(russianCheckBoxTitle)
        view.findViewById<TextView>(R.id.otherCategory).setText(otherCheckBoxTitle)
        view.findViewById<TextView>(R.id.timeCount).setText(roudDuration.toString())
        view.findViewById<TextView>(R.id.pointCount).setText(roudPoint.toString())
        view.findViewById<TextView>(R.id.pPointCount).setText(roudIncrementPoint.toString())
        inputFirstTeam = view.findViewById<EditText>(R.id.inputFirstTeam)
        inputSecondTeam = view.findViewById<EditText>(R.id.inputSecondTeam)
        val durationUpButton = view.findViewById<ImageButton>(R.id.upCount)
        durationUpButton.setOnClickListener {
            if (roudDuration < 999) {
                roudDuration++
            }
            view.findViewById<TextView>(R.id.timeCount).setText(roudDuration.toString())
        }

        val durationDownButton = view.findViewById<ImageButton>(R.id.downCount)
        durationDownButton.setOnClickListener {
            if (roudDuration > 10) {
                roudDuration--
            }
            view.findViewById<TextView>(R.id.timeCount).setText(roudDuration.toString())
        }

        val pointUpButton = view.findViewById<ImageButton>(R.id.upPointCount)
        pointUpButton.setOnClickListener {
            if (roudPoint < 999) {
                roudPoint++
            }
            view.findViewById<TextView>(R.id.pointCount).setText(roudPoint.toString())
        }

        val pointDownButton = view.findViewById<ImageButton>(R.id.downPointCount)
        pointDownButton.setOnClickListener {
            if (roudPoint > 10) {
                roudPoint--
            }
            view.findViewById<TextView>(R.id.pointCount).setText(roudPoint.toString())
        }

        val incrementPointUpButton = view.findViewById<ImageButton>(R.id.uppPointCount)
        incrementPointUpButton.setOnClickListener {
            if (roudIncrementPoint < 999) {
                roudIncrementPoint++
            }
            view.findViewById<TextView>(R.id.pPointCount).setText(roudIncrementPoint.toString())
        }

        val incrementPointDownButton = view.findViewById<ImageButton>(R.id.downpPointCount)
        incrementPointDownButton.setOnClickListener {
            if (roudIncrementPoint > 10) {
                roudIncrementPoint--
            }
            view.findViewById<TextView>(R.id.pPointCount).setText(roudIncrementPoint.toString())
        }

        val generateGameButton = view.findViewById<Button>(R.id.generateGame)
        generateGameButton.setOnClickListener {
            listener.generateGame(
                inputFirstTeam.getText().toString(),
                inputSecondTeam.getText().toString(),
                roudDuration,
                roudPoint,
                roudIncrementPoint
            )
        }
        return view
    }

    companion object {

        fun newInstance(activity: MainActivity): Fragment {
            val fragment = GeneratePageFragment()
            fragment.listener = activity
            return fragment
        }


    }
}