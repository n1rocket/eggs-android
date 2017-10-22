package com.mindorks.framework.mvp.ui.splash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class SplashActivityModule {

    //Splash
    @Provides
    SplashContract.Presenter<SplashContract.View, SplashContract.Interactor> provideSplashPresenter(
            SplashPresenter<SplashContract.View, SplashContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
            SplashContract.Interactor provideSplashMvpInteractor(SplashInteractor interactor) {
        return interactor;
    }
}
