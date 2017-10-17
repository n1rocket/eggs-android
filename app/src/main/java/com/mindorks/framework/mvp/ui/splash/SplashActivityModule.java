package com.mindorks.framework.mvp.ui.splash;

import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.main.MainInteractor;
import com.mindorks.framework.mvp.ui.main.MainMvpInteractor;
import com.mindorks.framework.mvp.ui.main.MainMvpPresenter;
import com.mindorks.framework.mvp.ui.main.MainMvpView;
import com.mindorks.framework.mvp.ui.main.MainPresenter;

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
