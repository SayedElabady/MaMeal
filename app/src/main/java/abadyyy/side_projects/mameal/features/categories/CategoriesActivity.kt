package abadyyy.side_projects.mameal.features.categories

import abadyyy.side_projects.mameal.R
import abadyyy.side_projects.mameal.databinding.ActivityCategoriesBinding
import abadyyy.side_projects.mameal.databinding.ItemCategoryBinding
import abadyyy.side_projects.mameal.shared.di.DaggerAwareViewModelFactory
import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import abadyyy.side_projects.mameal.shared.ui.bindingadapters.SimpleBindingRecyclerAdapter
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CategoriesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: DaggerAwareViewModelFactory
    private val viewModel by lazy { ViewModelProvider(this, factory).get(CategoriesViewModel::class.java) }
    private val categoriesAdapter = SimpleBindingRecyclerAdapter<CategoryEntity, ItemCategoryBinding>(
        R.layout.item_category,
        BR.uiModel
    )
    lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCategoriesBinding>(
            this@CategoriesActivity,
            R.layout.activity_categories
        ).apply {
            viewModel = this@CategoriesActivity.viewModel
            lifecycleOwner = this@CategoriesActivity
        }
        initViews()
        observeData()
    }

    private fun initViews() {
        binding.categoriesRv.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(this@CategoriesActivity)
        }

    }

    private fun observeData() {
        viewModel.categories.observe(this, Observer {
            categoriesAdapter.addItems(it)
        })

    }
}
