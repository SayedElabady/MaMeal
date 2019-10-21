package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.features.categories.CategoriesModule
import abadyyy.side_projects.mameal.features.categories.CategoriesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(
        modules = [CategoriesModule::class])
     internal abstract fun bindsMainActivityInjector(): CategoriesActivity
}