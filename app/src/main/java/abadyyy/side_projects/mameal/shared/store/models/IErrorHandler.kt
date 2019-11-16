package abadyyy.side_projects.mameal.data.store.models

interface IErrorHandler{

    fun getError(throwable: Throwable) : ErrorModel
}