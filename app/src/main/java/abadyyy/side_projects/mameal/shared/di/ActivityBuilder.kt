package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.features.categories.CategoriesActivity
import abadyyy.side_projects.mameal.features.categories.CategoriesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(
        modules = [CategoriesModule::class])
     internal abstract fun bindsCategoriesActivity(): CategoriesActivity
}