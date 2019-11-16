package abadyyy.side_projects.mameal.data.store.api.datastore

import abadyyy.side_projects.mameal.data.store.api.IMaMealService
import javax.inject.Inject

class CategoriesAPI @Inject constructor(
    val service: IMaMealService
) {

    fun getRemoteCategories() = service.getCategories()

}