package abadyyy.side_projects.mameal.shared.store.api

import javax.inject.Inject

class CachePolicy @Inject constructor(){
    fun provideCacheSize() = 10 * 1024 * 1024
}