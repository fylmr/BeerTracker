package com.example.fylmr.beertracker.tracker

import org.junit.Rule
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.modules.junit4.rule.PowerMockRule
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
class TrackerActivityTest {
    @get:Rule
    var rule = PowerMockRule()

    private lateinit var activity: TrackerActivity


}