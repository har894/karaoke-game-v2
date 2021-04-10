package com.example.karaok



interface ParamsListener {
    fun generateGame(firstTeamName: String, secondTeamName: String, duration: Int, point: Int, pPoint: Int)
}