package abadyyy.side_projects.mameal.shared.store.usecase

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UIObserverSchedulerProvider @Inject constructor() : ISchedulerProvider {
    override fun providePostExecuteScheduler() = Schedulers.io()

    override fun provideWorkerScheduler(): Scheduler = AndroidSchedulers.mainThread()
}