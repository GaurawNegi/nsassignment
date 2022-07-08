package com.gauraw.nsassessment.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gauraw.nsassessment.R
import com.gauraw.nsassessment.presentation.data.model.Station
import com.gauraw.nsassessment.presentation.viewmodel.HomeScreenViewModel

class HomeScreenComposeProvider {

    @Preview
    @Composable
    fun HomeScreenView(viewModel: HomeScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
        val value by viewModel.getStationList().observeAsState()
        StationListView(value ?: emptyList())
    }

    @Preview
    @Composable
    fun StationListView(items: List<Station> = emptyList()) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(items) {
                StationListItem(station = it)
            }
        }
    }

    @Composable
    fun StationListItem(station: Station) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = stringResource(
                            R.string.station_card_title,
                            station.name,
                            station.country
                        ),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = stringResource(
                            R.string.station_card_sub_title,
                            station.ingangsDatum
                        ),
                        style = MaterialTheme.typography.caption
                    )
                    Text(
                        text = station.stationType,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

    }
}