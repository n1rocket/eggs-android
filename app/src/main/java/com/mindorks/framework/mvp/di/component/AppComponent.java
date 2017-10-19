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

package com.mindorks.framework.mvp.di.component;

import android.app.Application;

import com.mindorks.framework.mvp.MvpApp;
import com.mindorks.framework.mvp.data.db.model.DaoSession;
import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.di.builders.ActivityBuilder;
import com.mindorks.framework.mvp.di.builders.FragmentBuilder;
import com.mindorks.framework.mvp.di.module.AppModule;
import com.mindorks.framework.mvp.service.SyncService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by n1rocketdev on 27/01/17.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MvpApp app);

    void inject(SyncService service);

    PreferencesHelper preferencesHelper();

    ApiHelper apiHelper();

    DaoSession daoSession();

    //CalligraphyConfig calligraphyDefaultConfig();
}