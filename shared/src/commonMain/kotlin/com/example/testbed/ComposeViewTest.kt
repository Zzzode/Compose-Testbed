package com.example.testbed

import androidx.compose.runtime.*

expect class ComposeViewTest {
    @Composable
    fun dolphinCompose(): String
}
