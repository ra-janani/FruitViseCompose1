package com.example.fruitvisecompose1.ui.fruits


sealed class Screen(val route:String){
    object Fruit:Screen(route="fruit_screen")
    object Detail:Screen(route="detail_screen/{id}")
}
