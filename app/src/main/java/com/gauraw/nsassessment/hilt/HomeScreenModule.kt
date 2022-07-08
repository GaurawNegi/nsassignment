package com.gauraw.nsassessment.hilt

import com.gauraw.nsassessment.network.StationsDataRepo
import com.gauraw.nsassessment.network.StationsDataRepoImpl
import com.gauraw.nsassessment.presentation.data.usecase.HomeScreenUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(ActivityComponent::class)
abstract class HomeScreenModule {

    @Binds
    abstract fun bindHomeScreenUseCase(homeScreenUseCase: HomeScreenUseCase): HomeScreenUseCase
}

@Module
@InstallIn(ViewModelComponent::class)
internal object HomeScreenViewModelMovieModule {

    @Provides
    @ViewModelScoped
    fun bindStationsDataRepo(): StationsDataRepo {
        return StationsDataRepoImpl()
    }

    @Provides
    @ViewModelScoped
    fun bindCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

}