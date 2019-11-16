package abadyyy.side_projects.mameal.data.store.usecase

import abadyyy.side_projects.mameal.data.di.Constants
import abadyyy.side_projects.mameal.data.di.MapperModule
import abadyyy.side_projects.mameal.data.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.data.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.data.store.models.CategoryEntity
import abadyyy.side_projects.mameal.data.store.models.Mapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class SaveCategoriesLocallyUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    private val dao: CategoriesDao,
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
                dao.replaceAll(*it.toTypedArray())
            }.toObservable()
    }

}