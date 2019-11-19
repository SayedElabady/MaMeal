package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.reactivex.Observable
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val categoriesAPI: CategoriesAPI,
    private val categoriesDao: CategoriesDao
) : ICategoriesRepository {
    override fun replaceLocalCategories(categories: List<CategoryEntity>): Observable<Unit> =
        Observable.just(categoriesDao.replaceAll(*categories.toTypedArray()))


    override fun getLocalCategories() = Observable.just(categoriesDao.findAll().find())

    override fun getRemoteCategories(): Observable<CategoriesResponse> =
        categoriesAPI.getRemoteCategories().toObservable()


}