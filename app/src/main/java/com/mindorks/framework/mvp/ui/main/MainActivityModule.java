package com.mindorks.framework.mvp.ui.main;

import android.support.v7.app.AppCompatActivity;

import com.mindorks.framework.mvp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class MainActivityModule {

    //Main
    @Provides
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }

    @Provides
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

//    @Provides
//    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
//        return new MainPagerAdapter(activity.getSupportFragmentManager());
//    }
}
