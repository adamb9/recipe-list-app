# Thoughts & Decisions
### Structure / Architecture
I tried to separate the app into a number of different packages/layers while trying to follow Clean Architecture guidelines. 
I ended up with the following packages:
 - **Entity:** This layer contained the entity classes that would be used within the app. It ended up with only `Recipe.kt` in it. 
I originally had an `Ingredient.kt` entity as well but it wasn't really necessary since it only contained the ingredient name. It also caused issues with JSON parsing which didn't seem like they were worth the time when a `String` would do just fine to contain each ingredient.
 - **Data:** This layer contained two subsections for the `api` and `repo` classes. Any functionality that would retrieve data from the `Recipes.json` file or from the API is located here.
 - **Interactors:** This layer handles any business logic within the app. For an app this small it may be a little over the top since it really only gets the recipe and ingredient information from the data layer and returns the recipes that are available with the current ingredients.
 - **Presentation:** The presentation layer contains the presenters that are used within the app. The `RecipeListPresenter` is the only presenter in this app. It acts as a buffer between the `view` and `interactors` and triggers changes in the view when the data is loaded. The presenters would play a much bigger part in a larger app that uses the MVP pattern.
 - **View:** This layer contains all activities, fragments, view interfaces, and view adapters. It calls the presenters to retrieve data and update the view when it is done. The `RecipeListView` interface allows the `RecipeListPresenter` to trigger changes in the `RecipeListFragment`.
 - **Utils:** This layer contains just one class called `JsonUtils`. `JsonUtils` contains a function that takes a Json file name as a parameter and returns a Json string that is parsed in the data layer using Gson.

**NOTE:** I realise the layers are not entirely decoupled from one another and are not cleanly split. To fix this it would have taken more time and I was very busy with college at the time of making this. 
One area in particular that was troublesome was the interaction surrounding `IngredientCallback`, `IngredientsRepoImpl`, and `RecipeListPresenterImpl`. If I had more time I would have tried to use `Dagger` for dependency injection and could have gotten a cleaner separation of layers.
I was also conscious of the fact that the task said that keeping it simple is ok and I didn't want to overcomplicate things.

### Dependencies
 - **Retrofit:** I used retrofit to make API requests to get the ingredients list.
 - **Gson:** I used Gson to parse JSON strings from the `Recipes.json` file and from the API response.
