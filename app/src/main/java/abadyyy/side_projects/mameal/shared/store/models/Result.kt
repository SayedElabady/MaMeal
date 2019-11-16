package abadyyy.side_projects.mameal.data.store.models

sealed class Result<T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Error<T>(val error: ErrorModel) : Result<T>()
}