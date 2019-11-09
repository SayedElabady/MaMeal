package abadyyy.side_projects.mameal.features

import abadyyy.side_projects.mameal.shared.store.models.ErrorHandler
import abadyyy.side_projects.mameal.shared.store.models.ErrorModel
import abadyyy.side_projects.mameal.shared.store.models.IErrorHandler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(val errorHandler: IErrorHandler = ErrorHandler()) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isLoading = MutableLiveData<Boolean>()
    val networkError = MutableLiveData<Boolean>()
    val notAvailableError = MutableLiveData<Boolean>()
    val notFoundError = MutableLiveData<Boolean>()
    val unknownError = MutableLiveData<Boolean>()
    private var onErrorClicked: (() -> Unit)? = null

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)


    fun handleError(error: Throwable, onErrorClicked: () -> Unit) {
        this.onErrorClicked = onErrorClicked
        isLoading.postValue(false)
        when (errorHandler.getError(error)) {
            is ErrorModel.NetworkError -> {
                notAvailableError.postValue(false)
                notFoundError.postValue(false)
                networkError.postValue(true)
                unknownError.postValue(false)
            }
            is ErrorModel.NotAvailable -> {
                notAvailableError.postValue(true)
                notFoundError.postValue(false)
                networkError.postValue(false)
                unknownError.postValue(false)

            }
            is ErrorModel.NotFound -> {
                notAvailableError.postValue(false)
                notFoundError.postValue(true)
                networkError.postValue(false)
                unknownError.postValue(false)

            }
            is ErrorModel.UnKnownError -> {
                notAvailableError.postValue(false)
                notFoundError.postValue(false)
                networkError.postValue(false)
                unknownError.postValue(true)
            }
        }

    }
    fun onErrorClicked() {
        onErrorClicked?.apply {
            invoke()
            unknownError.postValue(false)
            networkError.postValue(false)
            notFoundError.postValue(false)
            notAvailableError.postValue(false)
            onErrorClicked = null
        }
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}