package nl.appautomatic.heartthinking.handoverview

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import nl.appautomatic.heartthinking.poker.Hand
import nl.appautomatic.heartthinking.utility.TextFileParser

class HandOverviewViewModel: ViewModel() {
    private var source: MutableLiveData<ArrayList<Hand>> = MutableLiveData()
    private val parser = TextFileParser()

    init {
        source.value = ArrayList()
        source.value!!.add(parser.hands[0])
    }

    fun getHands(): MutableLiveData<ArrayList<Hand>> {
        return source
    }

    fun addHand() {
        source.value!!.add(parser.hands[1])
    }
}