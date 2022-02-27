package com.example.juniortechtask.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortechtask.R
import com.example.juniortechtask.entity.Recipe
import com.example.juniortechtask.presentation.RecipeListPresenter
import com.example.juniortechtask.presentation.RecipeListPresenterImpl

class RecipeListFragment : Fragment(), RecipeListView {

    private val recipeListPresenter: RecipeListPresenter = RecipeListPresenterImpl(this)
    private var recipeList: MutableList<Recipe> = mutableListOf()
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeListPresenter.getAvailableRecipes(context!!)

        recyclerview = view.findViewById(R.id.recipeRecyclerview)

        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecipeRecyclerViewAdapter(recipeList)
        }

    }

    override fun updateData(updatedRecipeList: List<Recipe>) {
        recipeList.addAll(updatedRecipeList)
        recyclerview.adapter!!.notifyDataSetChanged()
    }

}