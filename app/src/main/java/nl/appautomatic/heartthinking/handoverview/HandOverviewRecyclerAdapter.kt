package nl.appautomatic.heartthinking.handoverview

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import nl.appautomatic.heartthinking.R
import nl.appautomatic.heartthinking.databinding.LayoutHandOverviewRecyclerItemBinding
import nl.appautomatic.heartthinking.handviewer.HandViewerActivity
import nl.appautomatic.heartthinking.poker.Hand

class HandOverviewRecyclerAdapter(val viewModel: HandOverviewViewModel, val context: Context) : RecyclerView.Adapter<HandOverviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HandOverviewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = DataBindingUtil.inflate<LayoutHandOverviewRecyclerItemBinding>(inflater, R.layout.layout_hand_overview_recycler_item, parent, false)
        binding.root.setOnClickListener {
            val i = Intent(context, HandViewerActivity::class.java)
            context.startActivity(i)

        }
        return HandOverviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewModel.getHands().value!!.size
    }

    override fun onBindViewHolder(holder: HandOverviewHolder, position: Int) {
        val hand: Hand = viewModel.getHands().value!![position]
        holder.bind(hand)
    }

}