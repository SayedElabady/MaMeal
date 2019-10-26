package abadyyy.side_projects.mameal.shared.store.dao

import abadyyy.side_projects.mameal.shared.store.models.CategoryEntity
import io.objectbox.Box
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder


class CategoriesDao constructor(val categoriesBox: Box<CategoryEntity>) {

    fun findAll(block: (QueryBuilder<CategoryEntity>.() -> Unit)? = null) =
        categoriesBox.query {
            block?.let {
                block()
            }
        }

    fun replaceAll(vararg objects: CategoryEntity) {
        removeAll()
        addAll(*objects)
    }

    fun addAll(vararg objects: CategoryEntity) {
        categoriesBox.put(*objects)
    }

    fun removeAll() {
        categoriesBox.removeAll()
    }

    fun count() = categoriesBox.count()


}