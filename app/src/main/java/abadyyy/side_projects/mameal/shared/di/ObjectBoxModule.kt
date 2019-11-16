package abadyyy.side_projects.mameal.data.di

import abadyyy.side_projects.mameal.data.store.models.MyObjectBox
import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
class ObjectBoxModule {

    @Provides
    @Singleton
    fun provideObjectStore(context: Context): BoxStore {
        return MyObjectBox.builder().androidContext(context).build()
    }

}