package abadyyy.side_projects.mameal.shared.store.useCase

import io.reactivex.Observable


abstract class UseCase<I, O>(val schedulerProvider: ISchedulerProvider) {

    operator fun invoke(
        input: I
    ): Observable<O> {
        return buildObservable(input)
            .subscribeOn(schedulerProvider.provideWorkerScheduler())
            .observeOn(schedulerProvider.providePostExecuteScheduler())
    }

    abstract fun buildObservable(input: I): Observable<O>
}