package abadyyy.side_projects.mameal.shared.store.usecase

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun provideWorkerScheduler(): Scheduler

    fun providePostExecuteScheduler(): Scheduler
}