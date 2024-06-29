package com.rs.layouts

import android.icu.number.Scale
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rs.layouts.ui.theme.LayoutsTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun leftScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Text(text = "Left Screen", color = Color.Black)
    }
}

@Composable
fun homeScreen(navController: NavController) {
    val list: List<String> = listOf(
        "Lazy Vertical Grids",
        "Lazy Horizontal Grids",
        "Lazy Columns",
        "Lazy Rows",
        "Columns",
        "Rows"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { item: String ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(item)
                            }
                            .padding(16.dp),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun rightScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Text(text = "Right Screen", color = Color.Black)
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "logo"
        )
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { NavigationBar(navController) }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController)
        }
    }
}
@Composable
fun AppScreen(){
    var showSplashScreen by remember { mutableStateOf(true) }

    var scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        showSplashScreen = false
    }

    if (showSplashScreen) {
        SplashScreen()
    } else {
        MainScreen()
    }
}


@Preview()
@Composable
fun prevScreen(showBackground: Boolean = true) {
    AppScreen()
}