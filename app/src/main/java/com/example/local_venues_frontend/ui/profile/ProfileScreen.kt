package com.example.local_venues_frontend.ui.profile

import android.content.ClipData
import android.graphics.PostProcessor
import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.local_venues_frontend.LocalVenuesApp
import com.example.local_venues_frontend.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableState()
        }
    }
}

@Preview
@Composable
fun Feed(){
    Column(){
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.profile_picture))
    }
}

@Preview
@Composable
fun ProfileScreen() {
//    var value by remember{
//        mutableStateOf("")
//    }

    val listState = rememberLazyListState()

    Box(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxWidth(1f)){

        Column(modifier = Modifier.padding(all = 8.dp)){

            Icon(Icons.Rounded.ArrowBack,
                modifier = Modifier.size(40.dp),
                contentDescription = "Back arrow")

            Spacer(modifier = Modifier.height(24.dp))

            Icon(
                Icons.Default.Person,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .padding(horizontal = 10.dp),
                contentDescription = "Contact profile picture")
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

            Text("This is about where the bio would go once we hook up the backend")
        }
    }

    LazyColumn(state = listState, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1F)
            .offset(x = 0.dp, y = 200.dp)
            .padding(8.dp)){

        item(){
            Text("wow this stuff is really a lot to figure out", textAlign = TextAlign.Center)
        }

    }

}