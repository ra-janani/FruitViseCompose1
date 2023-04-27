package com.example.fruityvisecompose.ui.fruits

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fruitvisecompose1.ui.fruits.Details
import com.example.fruitvisecompose1.ui.fruits.Screen
import com.example.fruityvisecompose.data.FruitsItemModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Fruits() {
    val fruitsViewModel = viewModel(modelClass = FruitsViewModel::class.java)
    val navController = rememberNavController()

    //val state by fruitsViewModel.fruits.collectAsState()
    NavHost(navController = navController, startDestination = Screen.Fruit.route) {
        composable(Screen.Fruit.route) {
            FruitsCard(fruitsViewModel, navController = navController)
        }
        composable(
            Screen.Detail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            Details(
                navController = navController,
                fruitsViewModel,
                it.arguments?.getInt("id").toString()

            )
        }
    }

    //FruitsCard()
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .height(56.dp)
            .background(Color(0xFF22324C)),
        Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "List of Fruits",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color=Color(0xFFC1D6F8),
            modifier = Modifier
                .padding(10.dp)
        )
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitsCard(fruitsViewModel: FruitsViewModel = hiltViewModel(), navController: NavController) {

    val state by fruitsViewModel.fruits.collectAsState()
    Scaffold(
        topBar = { Toolbar() }
    ) {
        Column() {

            Toolbar()
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                if (state.isEmpty()) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
//                                .wrapContentSize(align = Alignment.Center)
                        )
                    }

                }

                items(state) { fruits: FruitsItemModel ->
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable { navController.navigate("detail_screen/" + fruits.id) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .background(Color(0xFF85ADEF)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            // shape= RoundedCornerShape(16.dp)

                        ) {
                            Text(text = "Fruit: ${fruits.name}")
                            Text(text = "Family: ${fruits.family}")
                            Text(text = "Genus: ${fruits.genus}")
                            Text(text = "Order: ${fruits.order}")

                        }
                    }


                }


            }
        }

    }
    }















