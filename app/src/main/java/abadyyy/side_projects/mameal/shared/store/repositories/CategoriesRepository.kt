package abadyyy.side_projects.mameal.data.store.repositories

import abadyyy.side_projects.mameal.data.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.data.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.data.store.models.CategoriesResponse
import io.reactivex.Observable
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val categoriesAPI: CategoriesAPI,
    private val categoriesDao: CategoriesDao
) : ICategoriesRepository {
    override fun getLocalCategories() = Observable.just(categoriesDao.findAll().find())

    override fun getRemoteCategories(): Observable<CategoriesResponse> =
        categoriesAPI.getRemoteCategories().toObservable()


}