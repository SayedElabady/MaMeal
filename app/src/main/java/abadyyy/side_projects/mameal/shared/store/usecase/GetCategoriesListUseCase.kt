package abadyyy.side_projects.mameal.data.store.usecase

import abadyyy.side_projects.mameal.data.di.Constants
import abadyyy.side_projects.mameal.data.store.models.CategoryEntity
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class GetCategoriesListUseCase @Inject constructor(
    @Named(Constants.UI_OBSERVER_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    private val localCategoriesUseCase: FetchLocalCategoriesUseCase,
    private val remoteCategoriesUseCase: FetchRemoteCategoriesUseCase,
    private val saveCategoriesLocallyUseCase: SaveCategoriesLocallyUseCase
) : ObservableUseCase<Unit, List<CategoryEntity>>(provider) {
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