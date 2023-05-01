package com.example.local_venues_frontend.mapshit

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.maps.android.compose.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.content.ContextCompat
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MapActivity : ComponentActivity() {

    private val applicationViewModel : ApplicationViewModel by viewModel<ApplicationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VenueMap()
        }
        prepLocationUpdates()
    }

    private fun prepLocationUpdates() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PERMISSION_GRANTED) {
            requestLocationUpdates()
        } else {
            requestSinglePermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private val requestSinglePermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            isGranted ->
        if (isGranted) {
            requestLocationUpdates()
        } else {
            Toast.makeText(this, "GPS Unavailable", Toast.LENGTH_LONG).show()
        }
    }

    private fun requestLocationUpdates() {
        applicationViewModel.startLocationUpdates()
    }

    private @Composable
    fun GPS(location: LocationDetails?){
        location?.let {
            Text(text = location.latitude)
            Text(text = location.longitude)
        }
    }

    @Preview
    @Composable
    private fun VenueMap() {

        // Ideally would iterate over Database of all events for getting all of the current venues,
        // but that's not functionality we have right now

        val location by applicationViewModel.getLocationLiveData().observeAsState()
        val da_class = LatLng(35.84115, -90.67778)
        val creegans = LatLng(35.842075638518025, -90.70498975861284)
        val brickhouse = LatLng(35.84146253579554, -90.70477427656665)
        val recovroom = LatLng(35.841377417656766, -90.70514928035128)
        val porchthirty = LatLng(35.838959601824136, -90.71006493941678)

        val cameraPosition = rememberCameraPositionState{
            position = CameraPosition.fromLatLngZoom(da_class, 15f)
        }

        GoogleMap (
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPosition
                ) {
            Marker(
                state = MarkerState(da_class),
                title = "CSM Building",
                snippet = "Where Dreams Go To Die"
            )
            Marker(
                state = MarkerState(creegans),
                title = "Creegans",
                snippet = "Irish Pub On Main, Stage Upstairs"
            )
            Marker(
                state = MarkerState(brickhouse),
                title = "Brickhouse",
                snippet = "American Grill on Main, Multiple Stages"
            )
            Marker(
                state = MarkerState(recovroom),
                title = "Recovery Room",
                snippet = "Bistro on Main, Frequently Holds 'Open Mic Nights'"
            )
            Marker(
                state = MarkerState(porchthirty),
                title = "Porch Thirty",
                snippet = "Outdoor Venue on Hunigton"
            )

        }
    }

}

