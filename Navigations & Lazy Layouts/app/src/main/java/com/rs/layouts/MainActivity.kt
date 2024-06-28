package com.rs.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                    MainScreen()
            }
        }
    }
}

@Composable
fun NavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("left_screen") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left),
                    contentDescription = "Left"
                )
            },
            label = {
                Text(text = "Left Screen")
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate("home_screen") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "home"
                )
            },
            label = {
                Text(text = "Home Screen")
            })
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("right_screen") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right),
                    contentDescription = "right"
                )
            },
            label = {
                Text(text = "Right Screen")
            })
    }
}

@Composable
fun NavigationHost(navController: NavController) {
    NavHost(navController = navController as NavHostController, startDestination = "home_screen") {
        composable("left_screen") { leftScreen() }
        composable("home_screen") { homeScreen() }
        composable("right_screen") { rightScreen() }
    }
}

@Composable
fun leftScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow), contentAlignment = Alignment.Center
    ) {
        Text(text = "Left Screen")
    }
}

@Composable
fun homeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            items(20) { item ->
                GridItem(item)
            }
        }
    }
}

@Composable
fun GridItem(index: Int) {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.size(100.dp),
            color = Color.LightGray,
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.android_alien),
                        contentDescription = "Alien",
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "Item $index",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxSize().padding(vertical = 10.dp),
                        textAlign = TextAlign.Center
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
            .background(Color.Magenta), contentAlignment = Alignment.Center
    ) {
        Text(text = "Right Screen")
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

@Preview()
@Composable
fun prevScreen(showBackground: Boolean = true) {
    //NavigationBar()
    //leftScreen()
    MainScreen()
}