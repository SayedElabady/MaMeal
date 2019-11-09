package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.features.BaseViewModel
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.store.useCase.GetCategoriesListUseCase
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    val categoriesUseCase: GetCategoriesListUseCase
) : BaseViewModel() {
    val categories = MutableLiveData<List<CategoryEntity>>()

    init {
        this.fetchCategories()
    }

    private fun fetchCategories() {
        addDisposable(categoriesUseCase.invoke(Unit)
            .doOnSubscribe { isLoading.value = true }
            .subscribe({
                isLoading.postValue(false)
                categories.postValue(it)
            }) {
                handleError(it){
                    fetchCategories()
                }
            })
    }

}