package com.example.juniortechtask.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortechtask.R
import com.example.juniortechtask.entity.Recipe

class RecipeRecyclerViewAdapter(private val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_list_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipeModel = recipeList[position]

        holder.recipeName.text = recipeModel.name
        holder.recipeIngredients.text = recipeModel.getIngredientsString()
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val recipeName: TextView = itemView.findViewById(R.id.recipeTextView)
        val recipeIngredients: TextView = itemView.findViewById(R.id.ingredientsTextView)
    }

}