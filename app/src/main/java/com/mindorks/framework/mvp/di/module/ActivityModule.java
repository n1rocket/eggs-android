/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mindorks.framework.mvp.data.network.model.BlogResponse;
import com.mindorks.framework.mvp.di.ActivityContext;
import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.info.InfoInteractor;
import com.mindorks.framework.mvp.ui.info.InfoMvpInteractor;
import com.mindorks.framework.mvp.ui.info.InfoMvpPresenter;
import com.mindorks.framework.mvp.ui.info.InfoMvpView;
import com.mindorks.framework.mvp.ui.info.InfoPresenter;
import com.mindorks.framework.mvp.ui.login.LoginInteractor;
import com.mindorks.framework.mvp.ui.login.LoginMvpInteractor;
import com.mindorks.framework.mvp.ui.login.LoginMvpPresenter;
import com.mindorks.framework.mvp.ui.login.LoginMvpView;
import com.mindorks.framework.mvp.ui.login.LoginPresenter;
import com.mindorks.framework.mvp.ui.main.MainInteractor;
import com.mindorks.framework.mvp.ui.main.MainMvpInteractor;
import com.mindorks.framework.mvp.ui.main.MainMvpPresenter;
import com.mindorks.framework.mvp.ui.main.MainMvpView;
import com.mindorks.framework.mvp.ui.main.MainPagerAdapter;
import com.mindorks.framework.mvp.ui.main.MainPresenter;
import com.mindorks.framework.mvp.ui.profile.ProfileInteractor;
import com.mindorks.framework.mvp.ui.profile.ProfileMvpInteractor;
import com.mindorks.framework.mvp.ui.profile.ProfileMvpPresenter;
import com.mindorks.framework.mvp.ui.profile.ProfileMvpView;
import com.mindorks.framework.mvp.ui.profile.ProfilePresenter;
import com.mindorks.framework.mvp.ui.sentences.SentencesAdapter;
import com.mindorks.framework.mvp.ui.sentences.SentencesInteractor;
import com.mindorks.framework.mvp.ui.sentences.SentencesMvpInteractor;
import com.mindorks.framework.mvp.ui.sentences.SentencesMvpPresenter;
import com.mindorks.framework.mvp.ui.sentences.SentencesMvpView;
import com.mindorks.framework.mvp.ui.sentences.SentencesPresenter;
import com.mindorks.framework.mvp.ui.splash.SplashInteractor;
import com.mindorks.framework.mvp.ui.splash.SplashMvpInteractor;
import com.mindorks.framework.mvp.ui.splash.SplashMvpPresenter;
import com.mindorks.framework.mvp.ui.splash.SplashMvpView;
import com.mindorks.framework.mvp.ui.splash.SplashPresenter;
import com.mindorks.framework.mvp.utils.rx.AppSchedulerProvider;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by n1rocketdev on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    //Splash
    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> provideSplashPresenter(
            SplashPresenter<SplashMvpView, SplashMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashMvpInteractor provideSplashMvpInteractor(SplashInteractor interactor) {
        return interactor;
    }

    //Login
    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> provideLoginPresenter(
            LoginPresenter<LoginMvpView, LoginMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpInteractor provideLoginMvpInteractor(LoginInteractor interactor) {
        return interactor;
    }

    //Main
    @Provides
    @PerActivity
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }

    @Provides
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    //Profile
    @Provides
    ProfileMvpPresenter<ProfileMvpView, ProfileMvpInteractor> provideProfilePresenter(
            ProfilePresenter<ProfileMvpView, ProfileMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileMvpInteractor provideProfileMvpInteractor(ProfileInteractor interactor) {
        return interactor;
    }

    //Info
    @Provides
    InfoMvpPresenter<InfoMvpView, InfoMvpInteractor> provideInfoPresenter(
            InfoPresenter<InfoMvpView, InfoMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    InfoMvpInteractor provideInfoMvpInteractor(InfoInteractor interactor) {
        return interactor;
    }

    //Sentences
    @Provides
    SentencesMvpPresenter<SentencesMvpView, SentencesMvpInteractor> provideSentencesMvpPresenter(
            SentencesPresenter<SentencesMvpView, SentencesMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    SentencesAdapter provideSentencesAdapter() {
        return new SentencesAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    @PerActivity
    SentencesMvpInteractor provideSentencesMvpInteractor(SentencesInteractor interactor) {
        return interactor;
    }
}
