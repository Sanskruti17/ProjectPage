package di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.repositiory.ProductRepositioryImpl
import model.repositiory.ProductRepositiory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositioryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepositiory(
        productRepositioryImpl: ProductRepositioryImpl
    ):ProductRepositiory
}