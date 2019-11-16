package abadyyy.side_projects.mameal.data.store.models

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories") val categories: List<Category>

) {
    data class Category(
        @SerializedName("idCategory") val categoryId: String,
        @SerializedName("strCategory") val name: String,
        @SerializedName("strCategoryThumb") val imgUrl: String,
        @SerializedName("strCategoryDescription") val description: String
    )
}