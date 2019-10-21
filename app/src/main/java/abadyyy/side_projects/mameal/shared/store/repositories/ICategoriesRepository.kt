package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Single

interface ICategoriesRepository {
    fun getCategories(): Single<List<CategoryEntity>>
}