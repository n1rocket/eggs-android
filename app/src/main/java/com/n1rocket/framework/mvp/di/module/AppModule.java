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

package com.n1rocket.framework.mvp.di.module;

import android.content.Context;

import com.n1rocket.framework.mvp.BuildConfig;
import com.n1rocket.framework.mvp.MvpApp;
import com.n1rocket.framework.mvp.R;
import com.n1rocket.framework.mvp.data.db.DbOpenHelper;
import com.n1rocket.framework.mvp.data.db.model.DaoMaster;
import com.n1rocket.framework.mvp.data.db.model.DaoSession;
import com.n1rocket.framework.mvp.data.network.ApiHeader;
import com.n1rocket.framework.mvp.data.network.ApiHelper;
import com.n1rocket.framework.mvp.data.network.AppApiHelper;
import com.n1rocket.framework.mvp.data.prefs.AppPreferencesHelper;
import com.n1rocket.framework.mvp.data.prefs.PreferencesHelper;
import com.n1rocket.framework.mvp.di.ApiInfo;
import com.n1rocket.framework.mvp.di.ApplicationContext;
import com.n1rocket.framework.mvp.di.DatabaseInfo;
import com.n1rocket.framework.mvp.di.PreferenceInfo;
import com.n1rocket.framework.mvp.utils.AppConstants;
import com.n1rocket.framework.mvp.utils.NetworkUtils;
import com.n1rocket.framework.mvp.utils.rx.AppSchedulerProvider;
import com.n1rocket.framework.mvp.utils.rx.SchedulerProvider;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Cache;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by n1rocketdev on 27/01/17.
 */

@Module(includes = AndroidInjectionModule.class)
public class AppModule {

    private static final String HTTP_CACHE_PATH = "http-cache";

    @Provides
    @ApplicationContext
    Context provideContext(MvpApp application) {
        return application.getApplicationContext();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(
            @ApiInfo String apiKey,
            PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DbOpenHelper dbOpenHelper) {
        return new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
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
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("isConnected")
    boolean provideIsConnected(@ApplicationContext Context context) {
        return NetworkUtils.isNetworkConnected(context);
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    int provideNetworkTimeoutInSeconds() {
        return AppConstants.NETWORK_CONNECTION_TIMEOUT;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(@ApplicationContext Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Singleton
    public Cache provideCache(@Named("cacheDir") File cacheDir, @Named("cacheSize") long cacheSize) {
        Cache cache = null;

        try {
            cache = new Cache(new File(cacheDir.getPath(), HTTP_CACHE_PATH), cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cache;
    }
    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return AppConstants.CACHE_SIZE;
    }

}
