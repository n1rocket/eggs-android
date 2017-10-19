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
    SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> provideSplashPresenter(
            SplashPresenter<SplashMvpView, SplashMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    SplashMvpInteractor provideSplashMvpInteractor(SplashInteractor interactor) {
        return interactor;
    }
}
