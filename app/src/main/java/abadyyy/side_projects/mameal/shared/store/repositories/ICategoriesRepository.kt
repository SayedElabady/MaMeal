package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Observable

interface ICategoriesRepository {

    fun getRemoteCategories(): Observable<CategoriesResponse>

    fun getLocalCategories(): Observable<List<CategoryEntity>>

    fun replaceLocalCategories(categories: List<CategoryEntity>): Observable<Unit>
}