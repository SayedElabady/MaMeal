package abadyyy.side_projects.mameal.shared.ui

import abadyyy.side_projects.mameal.shared.store.models.ErrorHandler
import abadyyy.side_projects.mameal.shared.store.models.ErrorModel
import abadyyy.side_projects.mameal.shared.store.models.IErrorHandler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel constructor(private val errorHandler: IErrorHandler = ErrorHandler()) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<ErrorModel>()
    private var onErrorClicked: (() -> Unit)? = null

    fun handleError(error: Throwable, onErrorClicked: () -> Unit) {
        this.onErrorClicked = onErrorClicked
        isLoading.postValue(false)
        this.error.postValue(errorHandler.getError(error))
    }

    fun onErrorClicked() {
        onErrorClicked?.apply {
            invoke()
            error.postValue(null)
            onErrorClicked = null
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun Disposable.addToDisposableBag() {
        compositeDisposable.add(this)
    }
}

