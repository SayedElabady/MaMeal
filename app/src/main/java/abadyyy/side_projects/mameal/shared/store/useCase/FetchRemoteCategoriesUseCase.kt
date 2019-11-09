package abadyyy.side_projects.mameal.shared.store.useCase

import abadyyy.side_projects.mameal.shared.di.Constants
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class FetchRemoteCategoriesUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    val repo: ICategoriesRepository
) :
    UseCase<Unit, List<CategoriesResponse.Category>>(provider) {
    override fun buildObservable(input: Unit): Observable<List<CategoriesResponse.Category>> {
        return repo.getRemoteCategories()
            .map { it.categories }


    }
}