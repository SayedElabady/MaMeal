package abadyyy.side_projects.mameal.shared.store.useCase

import abadyyy.side_projects.mameal.shared.di.Constants
import abadyyy.side_projects.mameal.shared.di.MapperModule
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.Mapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class SaveCategoriesLocallyUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    val dao: CategoriesDao,
    @Named(MapperModule.CATEGORIES_MAPPER) val mapper: Mapper<CategoriesResponse.Category, CategoryEntity>
) :
    UseCase<List<CategoriesResponse.Category>, List<CategoryEntity>>(provider) {
    override fun buildObservable(input: List<CategoriesResponse.Category>): Observable<List<CategoryEntity>> {
        return Observable.just(input)
            .map { list ->
                list.map { mapper.map(it) }
            }.map {
                dao.replaceAll(*it.toTypedArray())
                it
            }
    }

}