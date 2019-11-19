package abadyyy.side_projects.mameal.shared.store.usecase

import abadyyy.side_projects.mameal.shared.di.Constants
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class FetchLocalCategoriesUseCase @Inject constructor(
    @Named(Constants.REGULAR_SCHEDULER_PROVIDER) provider: ISchedulerProvider,
    private val repo: ICategoriesRepository
) :
    ObservableUseCase<Unit, List<CategoryEntity>>(provider) {
    override fun buildObservable(input: Unit): Observable<List<CategoryEntity>> {
        return repo.getLocalCategories()

    }
}