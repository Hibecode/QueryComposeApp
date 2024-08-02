package com.ibukun.query

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ibukun.query.navigation.QueryNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QueryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            QueryNavGraph()
        }
    }
}