package com.rs.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rs.layouts.ui.theme.LayoutsTheme

class NavigationController : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {

            }
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen"){ SplashScreen(navController = navController)}
        composable("main_screen") { MainScreen(navController)}
        composable("left_screen") { LeftScreen() }
        composable("home_screen") { HomeScreen(navController) }
        composable("right_screen") { RightScreen() }
        composable("Lazy Vertical Grids"){lazyVerticalGrid()}
        composable("Lazy Horizontal Grids"){lazyHorizontalGrid()}
        composable("Lazy Columns"){lazyColumns()}
        composable("Lazy Rows"){ lazyRows() }
        composable("Columns"){ columns() }
        composable("Rows"){ rows() }
    }
}

@Composable
fun NavigationBar(navController: NavController) {
    androidx.compose.material3.NavigationBar(
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LayoutsTheme {

    }
}