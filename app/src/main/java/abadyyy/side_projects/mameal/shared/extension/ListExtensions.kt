package abadyyy.side_projects.mameal.shared.extension

import io.reactivex.Single

fun<T> List<T>.toSingle() = Single.just(this)