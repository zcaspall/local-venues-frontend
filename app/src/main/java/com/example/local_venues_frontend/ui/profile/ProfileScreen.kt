package com.example.local_venues_frontend.ui.profile


// import android.content.ClipData
// import android.graphics.PostProcessor
// import android.media.Image
//import android.content.ClipData


import android.content.ClipData
import android.graphics.PostProcessor
import android.media.Image

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
// import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
// import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
// import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.ArrowBack

import androidx.compose.material.icons.rounded.Person
// import androidx.compose.material.icons.rounded.ShoppingCart

import androidx.compose.material.icons.rounded.ShoppingCart

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
// import androidx.compose.ui.semantics.Role.Companion.Image

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.semantics.Role.Companion.Image

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
// import androidx.core.view.ScrollingView
// import com.example.local_venues_frontend.LocalVenuesApp

import androidx.core.view.ScrollingView
import com.example.local_venues_frontend.LocalVenuesApp

import com.example.local_venues_frontend.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Preview
@Composable
fun ProfileScreen() {

    Box(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxWidth(1f)){

        Column(modifier = Modifier.padding(all = 8.dp)){

            Spacer(modifier = Modifier.height(64.dp))

            Icon(Icons.Rounded.Person,
            modifier = Modifier.size(45.dp),
            contentDescription = null)
        }

        Row(horizontalArrangement = Arrangement.Center){
            Text("Username Placeholder",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(500.dp)
                    .padding(16.dp))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(500.dp)
                .padding(70.dp)){

            Text("This is the biography area, tell people about yourself")
        }
    }
    // This box is where the posts will be viewed
    Box(modifier = Modifier
        .offset(y = 170.dp)
        .background(Color.LightGray)
        .fillMaxWidth(1f)){

        PostColumn()
    }
}

@Composable
fun PostColumn(modifier: Modifier = Modifier){
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(colorResource(R.color.purple_200))
                    .offset( y = 8.dp)
                    .fillMaxWidth()

    ){
        item{
            PostElement(drawable = VenueList[0].venueImage, text = VenueList[0].name)
        }
        item{
            PostElement(drawable = VenueList[1].venueImage, text = VenueList[1].name)
        }
        item{
            PostElement(drawable = VenueList[2].venueImage, text = VenueList[2].name)
        }
        item{
            PostElement(drawable = VenueList[3].venueImage, text = VenueList[3].name)
        }
        item{
            PostElement(drawable = VenueList[4].venueImage, text = VenueList[4].name)
        }
    }
        
}

@Composable
fun PostElement(
    @DrawableRes drawable: Int,
    text: String,
    modifier: Modifier = Modifier){

    Column(
        modifier = Modifier
            .width(180.dp)
            .background(colorResource(R.color.purple_200)),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = text,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 24.dp),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PostElementPreview() {

        PostElement(
            text = VenueList[0].name,
            drawable = R.drawable.gun_lady,
            modifier = Modifier.padding(8.dp)
        )
}
