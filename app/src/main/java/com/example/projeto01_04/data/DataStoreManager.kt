package com.example.projeto01_04.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.projeto01_04.ui.theme.data.ThemeOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {

    companion object {
        private val THEME_KEY = stringPreferencesKey("theme_option")
    }

    suspend fun saveTheme(theme: ThemeOption){
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme.name
        }
    }

    val themeFlow: Flow<ThemeOption> = context.dataStore.data.map { preferences ->
        val savedTheme = preferences[THEME_KEY] ?: ThemeOption.SYSTEM.name
        try{
            ThemeOption.valueOf(savedTheme)
        }catch (e: IllegalArgumentException){
            ThemeOption.SYSTEM
        }
    }
}


