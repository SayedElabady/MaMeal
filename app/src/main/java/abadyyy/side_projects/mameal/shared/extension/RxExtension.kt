package abadyyy.side_projects.mameal.shared.extension

import io.reactivex.Observable

fun <T> Observable<T>.toResult(): Observable<Result<T>> =
    this.map { item: T ->
        Result.success(item)
    }.onErrorReturn {
        Result.failure(it)
    }
