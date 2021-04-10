package com.example.karaok

import android.R.attr.key
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*


class RoundPageFragment : Fragment() {
    val list = Util.getTemparraryList()
    lateinit var currentTeamName:String
    var isFirst:Boolean = false
    var pPoint: Int = 0
    var duration: Int = 0
    var random: Int = 0
    var point: Int = 0
    var roundPoint: Int = 0
    var time: Long = 0
    var increment = 0
    lateinit var previeusFragment:Fragment
    lateinit var timer: CountDownTimer
    lateinit var text: TextView
    lateinit var timerTextView: TextView
    lateinit var progressBar: ProgressBar
    lateinit var artist: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_round_page, container, false)
        text = view.findViewById<TextView>(R.id.countText)
        artist = view.findViewById(R.id.textView)
        artist.setText(getArtist())
        view.findViewById<TextView>(R.id.text).setText(currentTeamName)
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.setProgress(100)
        timerTextView = view.findViewById<TextView>(R.id.timer)

        val btn = view.findViewById<Button>(R.id.rightButton).setOnClickListener {
            roundPoint++
            text.setText(roundPoint.toString())
            artist.setText(getArtist())
        }
        val btn1 = view.findViewById<Button>(R.id.wrongButton).setOnClickListener {
            updateTimer()
            artist.setText(getArtist())
        }
        timer()
        return view
    }



    fun getArtist(): String {
        random = Random(System.nanoTime()).nextInt(list.size)
        val str=list[random]
        list.removeAt(random)
        return str
    }

    fun timer() {
        var firstTick = true
        var temporaryTime = 0L
        timer = object : CountDownTimer(time, 100) {
            override fun onTick(millisUntilFinished: Long) {
                if (firstTick) {
                    temporaryTime = millisUntilFinished
                    firstTick = false
                }
                time = millisUntilFinished
                timerTextView.setText("" + (millisUntilFinished * 100 / temporaryTime).toInt())
                progressBar.setSecondaryProgress((millisUntilFinished * 100 / temporaryTime).toInt())
            }

            override fun onFinish() {
                val fragment =previeusFragment
                val bundle = Bundle()
                bundle.putInt("roundPoint", roundPoint)
                bundle.putString("currentTeamName", currentTeamName)
                fragment!!.arguments = bundle
                activity?.onBackPressed()
            }
        }.start()
    }

    fun updateTimer() {
        timer.cancel()
        time = time - increment
        timer()
    }

    companion object {

        fun newInstance(previeusFragment:Fragment,duration:Int,pPoint:Int,point:Int,currentTeamName:String):Fragment {
           val fragment =RoundPageFragment()
           fragment. previeusFragment= previeusFragment
            fragment.time=duration*1000L
            fragment.increment= (pPoint*1000L).toInt()
            fragment.point=point
            fragment.currentTeamName=currentTeamName
            return fragment
        }


    }
}