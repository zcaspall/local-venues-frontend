package com.example.local_venues_frontend.ui.profile

import androidx.annotation.DrawableRes
import com.example.local_venues_frontend.R

data class VenueData(
    val name: String,
    @DrawableRes val venueImage: Int
)

val Creegans = VenueData("Creegans", R.drawable.creegans)
val Midnight = VenueData("Midnight Rodeo", R.drawable.gun_lady)
val Brick = VenueData("Brickhouse", R.drawable.brickhouse)
val Recovery = VenueData("Recovery Room", R.drawable.recovery_room)
val Jtown = VenueData("Jtowns", R.drawable.jtowns)

val VenueList = listOf<VenueData>(
        Creegans,
        Midnight,
        Brick,
        Recovery,
        Jtown
)


