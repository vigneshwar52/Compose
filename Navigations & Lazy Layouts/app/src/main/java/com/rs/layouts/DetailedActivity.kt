package com.rs.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rs.layouts.ui.theme.LayoutsTheme

class DetailedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun lazyVerticalGrid() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.surfaceVariant)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(100) { item ->
                GridItem(item.toString())
            }
        }
    }
}
@Composable
fun lazyHorizontalGrid(){
    val rowList:List<String> = listOf(
        "Apple", "Orange", "Banana", "Pineapple", "Jackfruit", "Woodapple", "Mango", "Papaya",
        "Grapes", "Watermelon", "Lychee", "Peach", "Pear", "Plum", "Cherry", "Strawberry",
        "Blueberry", "Raspberry", "Blackberry", "Kiwi", "Guava", "Pomegranate", "Apricot",
        "Dragon Fruit", "Fig", "Cantaloupe", "Honeydew", "Tangerine", "Clementine", "Nectarine",
        "Passion Fruit", "Starfruit", "Mulberry", "Cranberry", "Boysenberry", "Gooseberry",
        "Rambutan", "Durian", "Persimmon", "Quince", "Pomelo", "Soursop", "Custard Apple",
        "Avocado", "Coconut", "Date", "Elderberry", "Feijoa", "Jujube", "Longan", "Loquat",
        "Mandarin", "Mangosteen", "Olive", "Tamarind", "Ugli Fruit", "Yuzu", "Sapodilla",
        "Salak", "Acerola", "Huckleberry", "Marionberry", "Miracle Fruit", "Nance", "Ackee",
        "Atemoya", "Babaco", "Bacaba", "Bael", "Bilberry", "Blackcurrant", "Breadfruit",
        "Camu Camu", "Cape Gooseberry", "Carambola", "Chokeberry", "Cloudberry", "Cupuacu",
        "Damson", "Dewberry", "Emu Apple", "Farkleberry", "Finger Lime", "Gac", "Genip",
        "Governor's Plum", "Grapple", "Greengage", "Hackberry", "Hala Fruit", "Illawarra Plum",
        "Indian Fig", "Jaboticaba", "Jambul", "Jocote", "Jostaberry", "Kaffir Lime", "Kei Apple"
    )
    Box(modifier = Modifier.fillMaxSize()){
        LazyHorizontalGrid(
            rows = GridCells.Fixed(4),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
            ) {
            items(rowList) { item -> GridItem(index = item) }
        }
    }
}
@Composable
fun GridItem(index: String) {
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
                        painter = painterResource(id = R.drawable.jetpack_compose),
                        contentDescription = "Alien",
                        modifier = Modifier.size(60.dp),
                        alignment = Alignment.Center
                    )
                    Text(
                        text = "Item : $index",
                        fontSize = 10.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
@Composable
fun lazyColumns(){
    var str:String?= null
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn{
            items(100){
                item->
                Box(modifier = Modifier.fillMaxSize()){
                    Column {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.jetpack_compose),
                                contentDescription = "Jetpack_Icon",
                                modifier = Modifier
                                    .size(150.dp)
                                    .border(BorderStroke(1.dp, Color.Black))
                                    .background(Color.Yellow)
                                    .clip(RoundedCornerShape(25.dp))
                            )
                            Box(modifier = Modifier
                                .background(Color.Gray)
                                .weight(1f)
                                .fillMaxHeight(),
                                contentAlignment = Alignment.Center,
                                 ){
                                Text(text = item.toString(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Blue,
                                    style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                }

            }
        }
    }
}
@Composable
fun lazyRows(){
    var str:String?= null
    Box(modifier = Modifier.fillMaxSize()){
        LazyRow{
            items(100){
                    item->
                Box(modifier = Modifier.fillMaxSize()){
                        Row() {
                            Column(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.jetpack_compose),
                                contentDescription = "Jetpack_Icon",
                                modifier = Modifier
                                    .size(150.dp)
                                    .border(BorderStroke(1.dp, Color.Black))
                                    .background(Color.Yellow)
                            )
                            Box(modifier = Modifier
                                .background(Color.Gray)
                                .fillMaxWidth(),
                                contentAlignment = Alignment.Center,
                            ){
                                Text(text = item.toString(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Blue,
                                    style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                }

            }
        }
    }
}
@Composable
fun columns(){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "Jetpack_Icon",
            modifier = Modifier
                .size(150.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .background(Color.Yellow)
        )
        Box(modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ){
            Text(text = "Column item",
                textAlign = TextAlign.Center,
                color = Color.Blue,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun rows(){
    Row(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "Jetpack_Icon",
            modifier = Modifier
                .size(150.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .background(Color.Yellow)
        )
        Box(modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ){
            Text(text = "Row item",
                textAlign = TextAlign.Center,
                color = Color.Blue,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutsTheme {
        lazyVerticalGrid();
//        lazyHorizontalGrid()
//        lazyColumns()
//        rows()
    }
}