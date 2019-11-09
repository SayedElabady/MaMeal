package abadyyy.side_projects.mameal.shared.store.useCase

import abadyyy.side_projects.mameal.shared.di.Constants
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class GetCategoriesListUseCase @Inject constructor(
    @Named(Constants.UI_OBSERVER_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    val localCategoriesUseCase: FetchLocalCategoriesUseCase,
    val remoteCategoriesUseCase: FetchRemoteCategoriesUseCase,
    val saveCategoriesLocallyUseCase: SaveCategoriesLocallyUseCase
) : UseCase<Unit, List<CategoryEntity>>(provider) {
    override fun buildObservable(input: Unit): Observable<List<CategoryEntity>> {
        return localCategoriesUseCase.invoke(Unit)
            .flatMap {
                if (it.isEmpty())
                    remoteCategoriesUseCase.invoke(Unit).flatMap {
                        saveCategoriesLocallyUseCase.invoke(it)
                    }
                else Observable.just(it)
            }
    }
}