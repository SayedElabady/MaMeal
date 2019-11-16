package abadyyy.side_projects.mameal.data.store.models

sealed class ErrorModel {
    abstract val exception: Throwable

    data class NetworkError(override val exception: Throwable) : ErrorModel()

    data class NotAvailable(override val exception: Throwable) : ErrorModel()

    data class NotFound(override val exception: Throwable) : ErrorModel()

    data class UnKnownError(override val exception: Throwable) : ErrorModel()

}