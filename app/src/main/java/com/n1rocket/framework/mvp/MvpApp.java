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

package com.n1rocket.framework.mvp;

import android.app.Activity;
import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.n1rocket.framework.mvp.BuildConfig;
import com.n1rocket.framework.mvp.di.builders.DaggerAndroidInjector;
import com.n1rocket.framework.mvp.di.component.AppComponent;
import com.n1rocket.framework.mvp.di.component.DaggerAppComponent;
import com.n1rocket.framework.mvp.utils.AppLogger;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by n1rocketdev on 27/01/17.
 */

public class MvpApp extends MultiDexApplication implements HasActivityInjector {

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        createAppComponent();

        DaggerAndroidInjector.initialize(this);

        AppLogger.init();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
        }

        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public void createAppComponent() {
        mAppComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();

        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.mAppComponent = appComponent;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
