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
    InfoContract.Presenter<InfoContract.View, InfoContract.Interactor> provideInfoPresenter(
            InfoPresenter<InfoContract.View, InfoContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
    InfoContract.Interactor provideInfoMvpInteractor(InfoInteractor interactor) {
        return interactor;
    }
}
