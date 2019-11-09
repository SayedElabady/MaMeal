package abadyyy.side_projects.mameal.shared.store.useCase

import abadyyy.side_projects.mameal.shared.di.Constants
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class SchedulerProvider @Inject constructor() : ISchedulerProvider {
    override fun providePostExecuteScheduler() = Schedulers.io()

    override fun provideWorkerScheduler() = Schedulers.io()

}