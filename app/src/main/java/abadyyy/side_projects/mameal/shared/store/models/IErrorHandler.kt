package abadyyy.side_projects.mameal.shared.store.models

interface IErrorHandler{

    fun getError(throwable: Throwable) : ErrorModel
}