@file:Suppress("PLUGIN_WARNING")

package nl.appautomatic.heartthinking

import android.arch.lifecycle.ViewModelProviders
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_card.view.*
import kotlinx.android.synthetic.main.layout_player.*
import kotlinx.android.synthetic.main.layout_player.view.*
import nl.appautomatic.heartthinking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    lateinit var handViewerViewModel: HandViewerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handViewerViewModel = ViewModelProviders.of(this).get(HandViewerViewModel::class.java)
        val hand: Hand = handViewerViewModel.getHand().value!!

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.hand, hand)
        binding.executePendingBindings()

        //TODO: Use databinding to load imageresource (Doesnt seem to work like texts)
        fillPlayerView(include1, hand.players[0])
        fillPlayerView(include2, hand.players[1])
        fillPlayerView(include3, hand.players[2])
        fillPlayerView(include4, hand.players[3])
        fillPlayerView(include5, hand.players[4])
        fillPlayerView(include6, hand.players[5])
    }

    private fun fillPlayerView(include: View, player: Player) {
        include.includeHoleCardOne.imageViewHoleCard.setImageResource(player.holeCardOne.imageResource)
        include.includeHoleCardTwo.imageViewHoleCard.setImageResource(player.holeCardTwo.imageResource)
        //include.textViewPlayerLayoutName.text = player.name
        //include.textViewPlayerLayoutChips.text = player.chips.toString()
    }

}
