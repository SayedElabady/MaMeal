package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.shared.di.Constants.REGULAR_SCHEDULER_PROVIDER
import abadyyy.side_projects.mameal.shared.di.Constants.UI_OBSERVER_SCHEDULER_PROVIDER
import abadyyy.side_projects.mameal.shared.store.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SchedulerProviderModule {
    @Provides
    @Singleton
    @Named(REGULAR_SCHEDULER_PROVIDER)
    fun provideSchedulerProvider(): ISchedulerProvider {
        return SchedulerProvider()
    }

    @Provides
    @Singleton
    @Named(UI_OBSERVER_SCHEDULER_PROVIDER)
    fun provideUIObserverSchedulerProvider(): ISchedulerProvider {
        return UIObserverSchedulerProvider()
    }

}