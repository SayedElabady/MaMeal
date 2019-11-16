package abadyyy.side_projects.mameal.data

import abadyyy.side_projects.mameal.data.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}