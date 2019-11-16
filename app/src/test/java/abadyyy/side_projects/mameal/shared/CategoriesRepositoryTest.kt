package abadyyy.side_projects.mameal.data

import abadyyy.side_projects.mameal.data.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.data.store.repositories.CategoriesRepository
import abadyyy.side_projects.mameal.data.store.repositories.ICategoriesRepository
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler
import org.junit.Test

import org.junit.Before

class CategoriesRepositoryTest : AbstractObjectBoxTest() {

    lateinit var scheduler: Scheduler
    lateinit var repository: ICategoriesRepository
    lateinit var remoteSource : CategoriesAPI
    
    @Before
    fun setup() {
        remoteSource = CategoriesAPI()
        scheduler = TestScheduler()

        repository = CategoriesRepository()
    }

    @Test
    fun getLocalCategories() {
    }

    @Test
    fun getRemoteCategories() {
    }
}