package abadyyy.side_projects.mameal.shared

import abadyyy.side_projects.mameal.shared.store.api.IMaMealService
import abadyyy.side_projects.mameal.shared.store.api.datastore.CategoriesAPI
import abadyyy.side_projects.mameal.shared.store.dao.CategoriesDao
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.models.MyObjectBox
import abadyyy.side_projects.mameal.shared.store.repositories.CategoriesRepository
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import io.reactivex.schedulers.TestScheduler
import io.reactivex.subscribers.TestSubscriber
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.io.File

@RunWith(MockitoJUnitRunner::class)
class CategoriesRepositoryTest {

    private lateinit var scheduler: TestScheduler
    private lateinit var repository: ICategoriesRepository

    @Mock
    private lateinit var remoteSource: IMaMealService
    private lateinit var localSource: CategoriesDao
    private val category = CategoryEntity(0, "id1", "categoryOne", "imgSrc", " categoryDescription")
    private var store: BoxStore? = null

    @Before
    fun setup() {
        store = MyObjectBox.builder()
            .directory(TEST_DIRECTORY)
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .build()
        scheduler = TestScheduler()
        localSource = CategoriesDao(store!!.boxFor(CategoryEntity::class.java))
        repository = CategoriesRepository(CategoriesAPI(remoteSource), localSource)
    }

    @Test
    fun testSavingLocalCategories() {
        val observer = repository.replaceLocalCategories(listOf(category))
            .subscribeOn(scheduler)
            .observeOn(scheduler)
            .test()
        scheduler.triggerActions()
        observer.assertComplete()
            .assertNoErrors()
            .dispose()
    }

    @Test
    fun getLocalCategories_Success() {
        val testObserver = repository.replaceLocalCategories(listOf(category))
            .flatMap {
                repository.getLocalCategories()
            }.subscribeOn(scheduler)
            .observeOn(scheduler)
            .test()
        scheduler.triggerActions()
        testObserver
            .assertValue { it.size == 1 }
            .assertValue {
                it[0].img == category.img && it[0].description == category.description
                        && it[0].name == category.name
            }
            .assertComplete()
            .assertNoErrors()
            .dispose()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        if (store != null) {
            store!!.close()
            store = null
        }
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
    }

    companion object {

        private val TEST_DIRECTORY = File("objectbox-example/test-db")
    }
}