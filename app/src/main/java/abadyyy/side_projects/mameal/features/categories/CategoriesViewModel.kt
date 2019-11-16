package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.shared.ui.BaseViewModel
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.usecase.GetCategoriesListUseCase
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    private val categoriesUseCase: GetCategoriesListUseCase
) : BaseViewModel() {
    val categories = MutableLiveData<List<CategoryEntity>>()

    init {
        this.fetchCategories()
    }

    private fun fetchCategories() {
        categoriesUseCase.invoke(Unit)
            .doOnSubscribe { isLoading.value = true }
            .subscribe({
                isLoading.postValue(false)
                categories.postValue(it)
            }) {
                handleError(it){
                    fetchCategories()
                }
            }.addToDisposableBag()
    }

}