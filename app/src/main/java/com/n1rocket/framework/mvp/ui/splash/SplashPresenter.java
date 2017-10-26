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

package com.n1rocket.framework.mvp.ui.splash;

import com.n1rocket.framework.mvp.ui.base.BasePresenter;
import com.n1rocket.framework.mvp.utils.AppConstants;
import com.n1rocket.framework.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by n1rocketdev on 27/01/17.
 */

public class SplashPresenter<V extends SplashContract.View, I extends SplashContract.Interactor>
        extends BasePresenter<V, I> implements SplashContract.Presenter<V, I> {

    @Inject
    public SplashPresenter(I mvpInteractor,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getMvpView().startSyncService();

        decideNextActivity();

    }

    private void decideNextActivity() {
        if (getInteractor().getCurrentUserLoggedInMode()
                == AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openMainActivity();
        }
    }
}
