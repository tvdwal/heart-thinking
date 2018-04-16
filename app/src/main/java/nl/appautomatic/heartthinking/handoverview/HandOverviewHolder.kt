package nl.appautomatic.heartthinking.handoverview

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import nl.appautomatic.heartthinking.BR
import nl.appautomatic.heartthinking.databinding.LayoutHandOverviewRecyclerItemBinding
import nl.appautomatic.heartthinking.poker.Hand

class HandOverviewHolder(binding: LayoutHandOverviewRecyclerItemBinding): RecyclerView.ViewHolder(binding.root) {

    private var binding: LayoutHandOverviewRecyclerItemBinding = DataBindingUtil.bind(itemView)!!

    fun bind(hand: Hand) {
        binding.setVariable(BR.hand, hand)
        binding.executePendingBindings()
    }

}