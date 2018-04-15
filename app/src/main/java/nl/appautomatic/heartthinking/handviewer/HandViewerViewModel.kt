package nl.appautomatic.heartthinking.handviewer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import nl.appautomatic.heartthinking.poker.Hand
import nl.appautomatic.heartthinking.utility.TextFileParser

class HandViewerViewModel: ViewModel() {
    private var handSource: MutableLiveData<Hand> = MutableLiveData()

    init {
        handSource.value = TextFileParser().getNextHand()
    }

    fun getHand(): MutableLiveData<Hand> {
        return handSource
    }
}