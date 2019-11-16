package abadyyy.side_projects.mameal.data.store.api

import javax.inject.Inject

class CachePolicy @Inject constructor(){
    fun provideCacheSize() = 10 * 1024 * 1024
}