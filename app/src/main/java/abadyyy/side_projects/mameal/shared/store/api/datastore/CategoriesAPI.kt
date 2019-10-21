package abadyyy.side_projects.mameal.shared.store.api.datastore

import abadyyy.side_projects.mameal.shared.di.MapperModule
import abadyyy.side_projects.mameal.shared.store.api.IMaMealService
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.Mapper
import javax.inject.Inject
import javax.inject.Named

class CategoriesAPI @Inject constructor(
    val service: IMaMealService,
    @Named(MapperModule.CATEGORIES_MAPPER) val mapper: Mapper<CategoriesResponse.Category, CategoryEntity>
) {
    fun getCategories() = service.getCategories()
        .map { it.categories.map { mapper.map(it) } }
}