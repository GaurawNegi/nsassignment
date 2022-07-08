package com.gauraw.nsassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.gauraw.nsassessment.presentation.compose.HomeScreenComposeProvider
import com.gauraw.nsassessment.presentation.viewmodel.HomeScreenViewModel
import com.gauraw.nsassessment.presentation.compose.theme.NSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: HomeScreenViewModel =
            ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        setContent {
            NSTheme {
                HomeScreenComposeProvider().HomeScreenView()
            }
        }
        if (savedInstanceState == null) {
            model.loadStations()
        }

    }

}