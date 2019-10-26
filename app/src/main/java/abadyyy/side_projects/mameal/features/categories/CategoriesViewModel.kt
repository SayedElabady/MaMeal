package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.features.BaseViewModel
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.repositories.CategoriesRepository
import abadyyy.side_projects.mameal.shared.store.repositories.ICategoriesRepository
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    val categoriesRepository: ICategoriesRepository
) : BaseViewModel() {
    val categories = MutableLiveData<List<CategoryEntity>>()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        addDisposable(categoriesRepository.getCategories()
            .doOnSubscribe { isLoading.postValue(true) }
            .doFinally { isLoading.postValue(false) }
            .subscribe({
                categories.postValue(it)
            }) {
                error.postValue(it)
            })
    }
}