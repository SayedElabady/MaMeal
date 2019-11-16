package abadyyy.side_projects.mameal.data.store.repositories

import abadyyy.side_projects.mameal.data.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.data.store.models.CategoryEntity
import io.reactivex.Observable

interface ICategoriesRepository {

    fun getRemoteCategories(): Observable<CategoriesResponse>

    fun getLocalCategories(): Observable<List<CategoryEntity>>
}