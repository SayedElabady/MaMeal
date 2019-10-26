package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.shared.di.ViewModelKey
import abadyyy.side_projects.mameal.shared.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.repositories.CategoriesRepository
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.objectbox.Box
import io.objectbox.BoxStore
import io.reactivex.Scheduler

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
    }

}