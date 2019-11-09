package abadyyy.side_projects.mameal.shared.store.repositories

import abadyyy.side_projects.mameal.shared.extension.toObservable
import abadyyy.side_projects.mameal.shared.extension.toSingle
import abadyyy.side_projects.mameal.shared.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoriesResponse
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.sharedpreferences.CategoriesMetaData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    val categoriesAPI: CategoriesAPI,
    val scheduler: Scheduler,
    val categoriesDao: CategoriesDao,
    val categoriesMetaData: CategoriesMetaData
) : ICategoriesRepository {
    override fun getLocalCategories() = categoriesDao.findAll().find().toObservable()


    override fun getRemoteCategories(): Observable<CategoriesResponse> =
        categoriesAPI.getRemoteCategories().toObservable()


    override fun getCategories(): Single<List<CategoryEntity>> {
        return categoriesDao.findAll()
                .find()
                .toSingle()
//        else
//            categoriesAPI.getRemoteCategories()
////                .map { it.categories.map { categoriesAPI.mapper.map(it) } }
////                .subscribeOn(scheduler)
////                .doOnSuccess {
////                    categoriesMetaData.isFetched = true
////                    categoriesDao.replaceAll(*it.toTypedArray())
////                }
    }
}