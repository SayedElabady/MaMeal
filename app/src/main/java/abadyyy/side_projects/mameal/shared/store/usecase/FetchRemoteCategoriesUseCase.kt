package abadyyy.side_projects.mameal.data.store.usecase

import abadyyy.side_projects.mameal.data.di.Constants
import abadyyy.side_projects.mameal.data.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.data.store.repositories.ICategoriesRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class FetchRemoteCategoriesUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    private val repo: ICategoriesRepository
) :
    ObservableUseCase<Unit, List<CategoriesResponse.Category>>(provider) {
    override fun buildObservable(input: Unit): Observable<List<CategoriesResponse.Category>> {
        return repo.getRemoteCategories()
            .map { it.categories }


    }
}