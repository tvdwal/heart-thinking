package nl.appautomatic.heartthinking.handviewer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import nl.appautomatic.heartthinking.poker.Hand
import nl.appautomatic.heartthinking.utility.TextFileParser

class HandViewerViewModel: ViewModel() {
    private var handSource: MutableLiveData<Hand> = MutableLiveData()

    init {
        handSource.value = Hand()
    }

    fun getHand(): MutableLiveData<Hand> {
        return handSource
    }

    fun setSourceForHandId(handId: String) {
        handSource.value = TextFileParser().getHandForHandId(handId)
    }
}