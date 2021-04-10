package com.example.karaok

class Util {

    fun customList(): ArrayList<String> {
        val singerList = ArrayList<String>()
        singerList.add("Արամ Ասատրյան")
        singerList.add("Արամե")
        singerList.add("Թաթա")
        singerList.add("Թաթուլ")
        singerList.add("ՀՏ Հայկո")
        return singerList
    }

    companion object {
        var singerList = customList()
        fun customList(): ArrayList<String> {
            val singerList = ArrayList<String>()
            singerList.add("Արամ Ասատրյան")
            singerList.add("Արամե")
            singerList.add("Թաթա")
            singerList.add("Թաթուլ")
            singerList.add("ՀՏ Հայկո")
            singerList.add("Արամ Ասատրյան")
            singerList.add("Արամե")
            singerList.add("Թաթա")
            singerList.add("Թաթուլ")
            singerList.add("ՀՏ Հայկո")
            singerList.add("Արամ Ասատրյան")
            singerList.add("Արամե")
            singerList.add("Թաթա")
            singerList.add("Թաթուլ")
            singerList.add("ՀՏ Հայկո")
            singerList.add("Արամ Ասատրյան")
            singerList.add("Արամե")
            singerList.add("Թաթա")
            singerList.add("Թաթուլ")
            singerList.add("ՀՏ Հայկո")
            singerList.add("Արամ Ասատրյան")
            singerList.add("Արամե")
            singerList.add("Թաթա")
            singerList.add("Թաթուլ")
            singerList.add("ՀՏ Հայկո")

            return singerList
        }
        fun getTemparraryList(): ArrayList<String> {
            return singerList.clone() as ArrayList<String>
        }
    }
}