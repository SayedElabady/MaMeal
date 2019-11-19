package abadyyy.side_projects.mameal.shared.store.usecase

import abadyyy.side_projects.mameal.shared.di.Constants
import abadyyy.side_projects.mameal.shared.di.MapperModule
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.Mapper
import abadyyy.side_projects.mameal.shared.store.repositories.CategoriesRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class SaveCategoriesLocallyUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    private val repository: CategoriesRepository,
    @Named(MapperModule.CATEGORIES_MAPPER)
    private val mapper: Mapper<CategoriesResponse.Category, CategoryEntity>
) :
    ObservableUseCase<List<CategoriesResponse.Category>, List<CategoryEntity>>(provider) {
    override fun buildObservable(input: List<CategoriesResponse.Category>): Observable<List<CategoryEntity>> {
        return Observable.just(input)
            .map { list ->
                list.map { mapper.map(it) }
            }.firstOrError()
            .doOnSuccess {
                repository.replaceLocalCategories(it)
            }.toObservable()
    }

}