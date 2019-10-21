package abadyyy.side_projects.mameal.shared.store.api

import abadyyy.side_projects.mameal.shared.Constants
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface IMaMealService {

    @GET(Constants.CATEGORIES_ENDPOINT)
    fun getCategories() : Single<CategoriesResponse>
}