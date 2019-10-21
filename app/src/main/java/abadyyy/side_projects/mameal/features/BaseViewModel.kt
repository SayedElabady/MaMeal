package abadyyy.side_projects.mameal.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Throwable>()

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}