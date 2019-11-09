package abadyyy.side_projects.mameal.shared.store.useCase

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun provideWorkerScheduler(): Scheduler

    fun providePostExecuteScheduler(): Scheduler
}