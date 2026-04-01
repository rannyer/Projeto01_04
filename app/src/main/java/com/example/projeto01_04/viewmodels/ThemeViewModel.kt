package com.example.projeto01_04.viewmodels

import android.app.Application
import androidx.compose.animation.scaleIn
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto01_04.data.DataStoreManager
import com.example.projeto01_04.ui.theme.data.ThemeOption
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ThemeViewModel(application: Application): AndroidViewModel(application) {
    private val dataStoreManager = DataStoreManager(application)

    val themeFlow = dataStoreManager.themeFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ThemeOption.SYSTEM
    )

    fun updateTheme(theme: ThemeOption) {
        viewModelScope.launch {
            dataStoreManager.saveTheme(theme)
        }
    }



}



