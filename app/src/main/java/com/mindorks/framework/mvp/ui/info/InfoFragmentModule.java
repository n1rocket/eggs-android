package com.mindorks.framework.mvp.ui.info;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class InfoFragmentModule {

    //Info
    @Provides
    InfoMvpPresenter<InfoMvpView, InfoMvpInteractor> provideInfoPresenter(
            InfoPresenter<InfoMvpView, InfoMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    InfoMvpInteractor provideInfoMvpInteractor(InfoInteractor interactor) {
        return interactor;
    }
}
