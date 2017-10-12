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

package com.mindorks.framework.mvp.ui.splash;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.data.db.repository.OptionRepository;
import com.mindorks.framework.mvp.data.db.repository.QuestionRepository;
import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.di.ApplicationContext;
import com.mindorks.framework.mvp.ui.base.BaseInteractor;
import com.mindorks.framework.mvp.utils.AppConstants;
import com.mindorks.framework.mvp.utils.FileUtils;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by n1rocketdev on 20/07/17.
 */

public class SplashInteractor extends BaseInteractor
        implements SplashMvpInteractor {

    private Context mContext;

    @Inject
    public SplashInteractor(@ApplicationContext Context context,
                            PreferencesHelper preferencesHelper,
                            ApiHelper apiHelper) {

        super(preferencesHelper, apiHelper);
        mContext = context;
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return getPreferencesHelper().getCurrentUserLoggedInMode();
    }
}
