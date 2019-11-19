package abadyyy.side_projects.mameal.shared.store.usecase

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProvider @Inject constructor() : ISchedulerProvider {
    override fun providePostExecuteScheduler() = Schedulers.io()

    override fun provideWorkerScheduler() = Schedulers.io()

}