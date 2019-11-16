package abadyyy.side_projects.mameal.data.store.api

import abadyyy.side_projects.mameal.data.Constants
import abadyyy.side_projects.mameal.data.store.models.CategoriesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface IMaMealService {

    @GET(Constants.CATEGORIES_ENDPOINT)
    fun getCategories() : Single<CategoriesResponse>
}