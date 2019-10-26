package abadyyy.side_projects.mameal.shared.store.sharedpreferences

import android.content.Context
import javax.inject.Inject


class CategoriesMetaData @Inject constructor(val context: Context) {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(
            CATEGORIES_SHARED_PREF,
            Context.MODE_PRIVATE
        )
    }

    var isFetched: Boolean
        get() = sharedPreferences.getBoolean(IS_FETCHED_KEY, false)
        set(value) {
            sharedPreferences.edit().putBoolean(IS_FETCHED_KEY, value).apply()
        }

    companion object {
        const val IS_FETCHED_KEY = "is_fetched"
        const val CATEGORIES_SHARED_PREF = "categories_shared_pref"
    }
}