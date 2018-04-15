package nl.appautomatic.heartthinking.handoverview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import nl.appautomatic.heartthinking.R

class HandOverviewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textViewHandId = itemView.findViewById(R.id.textViewRecyclerItemHandId) as TextView
    val textViewSmallBlind = itemView.findViewById(R.id.textViewRecyclerItemSmallBlind) as TextView
    val textViewBigBlind = itemView.findViewById(R.id.textViewRecyclerItemBigBlind) as TextView
}