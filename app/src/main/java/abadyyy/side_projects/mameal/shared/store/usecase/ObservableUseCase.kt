package abadyyy.side_projects.mameal.data.store.usecase

import io.reactivex.Observable


abstract class ObservableUseCase<I, O>(val schedulerProvider: ISchedulerProvider) {

    operator fun invoke(
        input: I
    ): Observable<O> {
        return buildObservable(input)
            .subscribeOn(schedulerProvider.provideWorkerScheduler())
            .observeOn(schedulerProvider.providePostExecuteScheduler())
    }

    abstract fun buildObservable(input: I): Observable<O>
}