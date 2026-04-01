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


@Composable
fun ThemeAppExericio(
    themeOption: ThemeOption,
    content: @Composable () -> Unit
){
    var darkTheme =  when(themeOption){
        ThemeOption.SYSTEM -> isSystemInDarkTheme()
        ThemeOption.LIGHT -> false
        ThemeOption.DARK -> true
    }
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )



}

@Composable
fun Projeto01_04Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}