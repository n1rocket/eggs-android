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

package com.mindorks.framework.mvp.ui.main;

import com.mindorks.framework.mvp.ui.base.BasePresenter;
import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpView;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by n1rocketdev on 25/05/17.
 */

public class MainPresenter<V extends MvpView, I extends MvpInteractor>
        extends BasePresenter<V, I> implements MainContract.Presenter<V, I> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(I mvpInteractor,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }
}
