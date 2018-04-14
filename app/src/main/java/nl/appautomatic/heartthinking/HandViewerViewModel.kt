package nl.appautomatic.heartthinking

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class HandViewerViewModel: ViewModel() {
    private var handSource: MutableLiveData<Hand> = MutableLiveData()

    init {
        handSource.value = TextFileParser().getNextHand()
    }

    fun getHand(): MutableLiveData<Hand> {
        return handSource
    }
}