package abadyyy.side_projects.mameal.data

import abadyyy.side_projects.mameal.data.store.models.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import org.junit.After
import org.junit.Before
import java.io.File

open class AbstractObjectBoxTest {

    protected var store: BoxStore? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
        store = MyObjectBox.builder()
            .directory(TEST_DIRECTORY)
            .debugFlags(DebugFlags.LOG_QUERIES or DebugFlags.LOG_QUERY_PARAMETERS)
            .build()
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