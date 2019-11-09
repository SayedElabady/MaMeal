package abadyyy.side_projects.mameal.shared.extension

import io.reactivex.Observable
import io.reactivex.Single

fun <T> List<T>.toSingle() = Single.just(this)

fun <T> List<T>.toObservable() = Observable.just(this)

