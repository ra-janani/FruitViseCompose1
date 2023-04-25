package com.example.fruityvisecompose.ui.fruits

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
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
fun Fruits(){
    val fruitsViewModel = viewModel(modelClass = FruitsViewModel::class.java)
    val navController= rememberNavController()

   //val state by fruitsViewModel.fruits.collectAsState()
    NavHost(navController = navController, startDestination = Screen.Fruit.route){
        composable(Screen.Fruit.route){
            FruitsCard(fruitsViewModel,navController=navController)
        }
        composable(Screen.Detail.route,
                    arguments= listOf(navArgument("id"){
                        type= NavType.IntType
                    })){
            Details(navController=navController,fruitsViewModel,it.arguments?.getInt("id").toString())
        }
    }

 //FruitsCard()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitsCard(fruitsViewModel: FruitsViewModel = viewModel(),navController: NavController) {

    val state by fruitsViewModel.fruits.collectAsState()

Column(modifier=Modifier.padding(8.dp)){

        Box {
            Surface(
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    .padding(horizontal = 4.dp),
                color = Color.Yellow,
                shape = CutCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Green)
                /*color= Color.Black,
                modifier = Modifier.align(Alignment.Center),
                contentColor = MaterialTheme.colorScheme.surface*/
            ) {

                Text(text = "List of Fruits",textAlign = TextAlign.Center,fontWeight = FontWeight.Bold)

            }


        }

        LazyColumn {
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }

            }

            items(state) { fruits: FruitsItemModel ->

    Card(

        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp)
            .clickable { navController.navigate("detail_screen/"+fruits.id)}
    ) {
        Box {


            Surface(
                color=MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
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
}

