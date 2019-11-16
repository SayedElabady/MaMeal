package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.shared.di.ViewModelKey
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.CategoryUIMapper
import abadyyy.side_projects.mameal.shared.store.models.Mapper
import abadyyy.side_projects.mameal.shared.store.repositories.CategoriesRepository
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module(includes = [CategoriesModule.Extension::class])
abstract class CategoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    abstract fun provideCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

    @Binds
    abstract fun provideRepository(
        categoriesRepository: CategoriesRepository
    ): ICategoriesRepository

    @Module
    class Extension{
        @Provides
        fun provideCategoriesBox(boxStore: BoxStore): Box<CategoryEntity> {
            return boxStore.boxFor(CategoryEntity::class.java)
        }
        @Provides
        fun provideCategoriesDao(box : Box<CategoryEntity>): CategoriesDao {
            return CategoriesDao(box)
        }
        @Provides
        @Singleton
        fun provideCategoriesMapper(): Mapper<CategoriesResponse.Category, CategoryEntity> {
            return CategoryUIMapper()
        }

    }

}