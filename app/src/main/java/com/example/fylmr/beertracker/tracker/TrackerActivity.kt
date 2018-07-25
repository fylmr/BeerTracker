package com.example.fylmr.beertracker.tracker

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.fylmr.beertracker.R

class TrackerActivity : MvpAppCompatActivity(), TrackerView {

    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)
    }


}
