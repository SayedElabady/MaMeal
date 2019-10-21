package abadyyy.side_projects.mameal.shared.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton


@Module
public class AppModule {

    @Provides
    @Singleton
    internal fun providesContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun providesSceduler(): Scheduler {
        return Schedulers.io()
    }

}