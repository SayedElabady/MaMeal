package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class CategoriesRepository @Inject constructor(val categoriesAPI: CategoriesAPI,
                                               val scheduler: Scheduler) : ICategoriesRepository{

    override fun getCategories(): Single<List<CategoryEntity>> {
        return categoriesAPI.getCategories()
            .subscribeOn(scheduler)
    }
}