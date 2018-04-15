package nl.appautomatic.heartthinking.handoverview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hand_overview.*
import nl.appautomatic.heartthinking.R
import nl.appautomatic.heartthinking.poker.Hand

class HandOverviewActivity : AppCompatActivity() {

    companion object {
        val TAG = "HandOverviewActivity"
    }

    lateinit var handOverviewViewModel: HandOverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hand_overview)

        handOverviewViewModel = ViewModelProviders.of(this).get(HandOverviewViewModel::class.java)

        recyclerViewHandOverview.layoutManager = LinearLayoutManager(this)
        recyclerViewHandOverview.adapter = HandOverviewRecyclerAdapter(handOverviewViewModel, this)

        handOverviewViewModel.getHands().observe(this, Observer<ArrayList<Hand>> {
            recyclerViewHandOverview.adapter.notifyDataSetChanged()
        })

        val handler = Handler()
        handler.postDelayed(Runnable {
            handOverviewViewModel.addHand()
        }, 5000)
    }

}
