package nl.appautomatic.heartthinking.handoverview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import nl.appautomatic.heartthinking.R
import nl.appautomatic.heartthinking.handviewer.HandViewerActivity
import nl.appautomatic.heartthinking.poker.Hand

class HandOverviewRecyclerAdapter(val viewModel: HandOverviewViewModel, val context: Context) : RecyclerView.Adapter<HandOverviewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HandOverviewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_hand_overview_recycler_item, parent, false)
        v.setOnClickListener {
            val i = Intent(context, HandViewerActivity::class.java)
            context.startActivity(i)
        }
        Toast.makeText(context, "Nr of items: " + itemCount, Toast.LENGTH_SHORT)
        return HandOverviewHolder(v)
    }

    override fun getItemCount(): Int {
        return viewModel.getHands().value!!.size
    }

    override fun onBindViewHolder(holder: HandOverviewHolder, position: Int) {
        val hand: Hand = viewModel.getHands().value!![position]
        holder.textViewBigBlind.text = hand.buttonIndex.toString()
        holder.textViewSmallBlind.text = hand.smallBlind.toString()
    }

}