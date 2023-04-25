package com.example.fruitvisecompose1.ui.fruits

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fruityvisecompose.data.FruitsItemModel
import com.example.fruityvisecompose.ui.fruits.FruitsViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(navController: NavController,fruitsViewModel: FruitsViewModel = viewModel(), id:String
){
    //val fruitsViewModel = viewModel(modelClass = FruitsViewModel::class.java)
    //val state by fruitsViewModel.fruits.collectAsState()
    val fruit = fruitsViewModel.fruits.collectAsState().value

   //val pos = fruit.indexOf("$id")

Column {

    Card(

        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp)

    ) {
        Box {


            Surface(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    for (i in 0..39) {

                        var item = fruit.get(i).id
                        if (item == ("$id").toInt())
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            ) {
                                Text(text = "Fruit: ${fruit.get(i).name}")
                                Text(text = "Fat: ${fruit.get(i).nutritions?.fat}")
                                Text(text = "calories: ${fruit.get(i).nutritions?.calories}")
                                Text(text = "carbohydrates: ${fruit.get(i).nutritions?.carbohydrates}")
                                Text(text = "protein: ${fruit.get(i).nutritions?.protein}")
                            }

                    }

                }
            }


        }


    }
    
    Button(onClick = {navController.navigate("fruit_screen") }) {

        Text(text="BACK")
        
    }

}

}