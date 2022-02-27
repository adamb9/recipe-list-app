package com.example.juniortechtask.entity

data class Recipe(
    val name: String,
    val ingredients: List<String>
) {
    // Small function to get a nice looking string of ingredients
    fun getIngredientsString(): String {
        var ingredientString = "Ingredients: "
        for (ingredient in ingredients) {
            ingredientString = ingredientString.plus(ingredient).plus(", ")
        }
        return ingredientString.dropLast(2)
    }
}
