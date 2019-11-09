package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.features.categories.CategoriesModule
import abadyyy.side_projects.mameal.shared.di.Constants.REGULAR_SCHEDULER_PROVIDER
import abadyyy.side_projects.mameal.shared.di.Constants.UI_OBSERVER_SCHEDULER_PROVIDER
import abadyyy.side_projects.mameal.shared.store.models.ErrorHandler
import abadyyy.side_projects.mameal.shared.store.models.IErrorHandler
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import abadyyy.side_projects.mameal.shared.store.useCase.*
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