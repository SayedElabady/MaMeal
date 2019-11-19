package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.CategoryUIMapper
import abadyyy.side_projects.mameal.shared.store.models.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MapperModule {

    @Provides
    @Singleton
    @Named(CATEGORIES_MAPPER)
    fun provideCategoriesMapper(): Mapper<CategoriesResponse.Category, CategoryEntity> {
        return CategoryUIMapper()
    }

    companion object {
        const val CATEGORIES_MAPPER = "categories_mapper"
    }
}