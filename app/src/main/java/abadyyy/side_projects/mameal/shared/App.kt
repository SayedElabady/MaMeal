package abadyyy.side_projects.mameal.shared

import abadyyy.side_projects.mameal.shared.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}