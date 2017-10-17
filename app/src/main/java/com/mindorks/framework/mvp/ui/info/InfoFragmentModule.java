package com.mindorks.framework.mvp.ui.info;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class InfoFragmentModule {

    @Provides
    InfoInteractor provideInfoMvpInteractor(InfoInteractor interactor) {
        return interactor;
    }

    @Provides
    InfoMvpPresenter<InfoMvpView, InfoMvpInteractor> provideInfoMvpPresenter(
            InfoPresenter<InfoMvpView, InfoMvpInteractor> presenter) {
        return presenter;
    }
}
