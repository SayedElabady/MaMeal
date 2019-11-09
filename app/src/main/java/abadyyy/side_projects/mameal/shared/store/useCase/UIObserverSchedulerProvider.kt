package abadyyy.side_projects.mameal.shared.store.useCase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UIObserverSchedulerProvider @Inject constructor() : ISchedulerProvider {
    override fun providePostExecuteScheduler() = Schedulers.io()

    override fun provideWorkerScheduler() = AndroidSchedulers.mainThread()

}