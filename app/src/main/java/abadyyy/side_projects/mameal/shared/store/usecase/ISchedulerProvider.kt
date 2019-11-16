package abadyyy.side_projects.mameal.data.store.usecase

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun provideWorkerScheduler(): Scheduler

    fun providePostExecuteScheduler(): Scheduler
}