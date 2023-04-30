package com.example.local_venues_frontend.mapshit

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {ApplicationViewModel(androidApplication())}
}