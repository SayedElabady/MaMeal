package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Observable
import io.reactivex.Single

interface ICategoriesRepository {
    fun getCategories(): Single<List<CategoryEntity>>

    fun getRemoteCategories(): Observable<CategoriesResponse>

    fun getLocalCategories(): Observable<List<CategoryEntity>>
}