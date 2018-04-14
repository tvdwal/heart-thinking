package nl.appautomatic.heartthinking

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_cards.*
import kotlinx.android.synthetic.main.layout_player.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    lateinit var handViewerViewModel: HandViewerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handViewerViewModel = ViewModelProviders.of(this).get(HandViewerViewModel::class.java)
        textViewPlayerLayoutName.text = "Tim"
        textViewPlayerLayoutChips.text = "999"
        val cardOne = Card("Ac")
        val cardTwo = Card("Td")
        imageViewHoleCardOne.setImageResource(cardOne.imageResource())
        imageViewHoleCardTwo.setImageResource(cardTwo.imageResource())
    }
}
