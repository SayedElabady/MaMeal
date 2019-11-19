package abadyyy.side_projects.mameal.shared.extension

import io.reactivex.Observable


fun <T> List<T>.toObservable() = Observable.just(this)

