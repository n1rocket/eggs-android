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

package com.n1rocket.framework.mvp.ui.login;

import com.n1rocket.framework.mvp.R;
import com.n1rocket.framework.mvp.data.network.model.ANError;
import com.n1rocket.framework.mvp.data.network.model.LoginRequest;
import com.n1rocket.framework.mvp.data.network.model.LoginResponse;
import com.n1rocket.framework.mvp.ui.base.BasePresenter;
import com.n1rocket.framework.mvp.utils.AppConstants;
import com.n1rocket.framework.mvp.utils.CommonUtils;
import com.n1rocket.framework.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by n1rocketdev on 27/01/17.
 */

public class LoginPresenter<V extends LoginContract.View, I extends LoginContract.Interactor>
        extends BasePresenter<V, I> implements LoginContract.Presenter<V, I> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(I mvpInteractor,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();

        getCompositeDisposable().add(getInteractor()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getInteractor().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        //getMvpView().openMainActivity();
                        getMvpView().openBottomActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void onGoogleLoginClick() {
        // instruct LoginActivity to initiate google login
        getMvpView().showLoading();

        getCompositeDisposable().add(getInteractor()
                .doGoogleLoginApiCall(new LoginRequest.GoogleLoginRequest("test1", "test1"))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getInteractor().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        //getMvpView().openMainActivity();
                        getMvpView().openBottomActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void onFacebookLoginClick() {
        // instruct LoginActivity to initiate facebook login
        getMvpView().showLoading();

        getCompositeDisposable().add(getInteractor()
                .doFacebookLoginApiCall(new LoginRequest.FacebookLoginRequest("test3", "test4"))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getInteractor().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                AppConstants.LoggedInMode.LOGGED_IN_MODE_FB,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        //getMvpView().openMainActivity();
                        getMvpView().openBottomActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
