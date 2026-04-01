package com.example.projeto01_04.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.projeto01_04.ui.theme.data.ThemeOption

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF818CF8),
    onPrimary = Color(0xFF6360AA),

    secondary = Color(0xFFC4B5FD),
    onSecondary = Color(0xFF2E1065),

    tertiary = Color(0xFFF9A8D4),
    onTertiary = Color(0xFF500724),

    background = Color(0xFF030712),
    onBackground = Color(0xFFE5E7EB),

    surface = Color(0xFF111827),
    onSurface = Color(0xFFE5E7EB),

    surfaceVariant = Color(0xFF1F2933),
    onSurfaceVariant = Color(0xFF9CA3AF),

    outline = Color(0xFF4B5563)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4F46E5),
    onPrimary = Color.White,

    secondary = Color(0xFF7C3AED),
    onSecondary = Color.White,

    tertiary = Color(0xFFEC4899),
    onTertiary = Color.White,

    background = Color(0xFFF9FAFB),
    onBackground = Color(0xFF111827),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF111827),

    surfaceVariant = Color(0xFFE5E7EB),
    onSurfaceVariant = Color(0xFF374151),

    outline = Color(0xFF9CA3AF)
)

private val NetflixDarkColorScheme = darkColorScheme(
    primary = Color(0xFFE50914), // Netflix red
    onPrimary = Color.White,

    secondary = Color(0xFFB20710),
    onSecondary = Color.White,

    tertiary = Color(0xFF221F1F),
    onTertiary = Color.White,

    background = Color(0xFF000000),
    onBackground = Color(0xFFE5E5E5),

    surface = Color(0xFF141414),
    onSurface = Color(0xFFE5E5E5),

    surfaceVariant = Color(0xFF2F2F2F),
    onSurfaceVariant = Color(0xFFB3B3B3),

    outline = Color(0xFF404040)
)

@Composable
fun ThemeAppExericio(
    themeOption: ThemeOption,
    content: @Composable () -> Unit
){
    var darkTheme =  when(themeOption){
        ThemeOption.SYSTEM -> isSystemInDarkTheme()
        ThemeOption.LIGHT -> false
        ThemeOption.DARK -> true
        ThemeOption.NETFLIX -> "n"
    }
    MaterialTheme(
        colorScheme = when(themeOption){
            ThemeOption.DARK -> DarkColorScheme
            ThemeOption.LIGHT -> LightColorScheme
            ThemeOption.SYSTEM -> LightColorScheme
            ThemeOption.NETFLIX -> NetflixDarkColorScheme
        },
        content = content
    )
}
