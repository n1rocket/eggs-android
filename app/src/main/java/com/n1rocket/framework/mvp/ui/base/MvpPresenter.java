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

package com.n1rocket.framework.mvp.ui.base;

/**
 * Created by n1rocketdev on 27/01/17.
 */


import com.n1rocket.framework.mvp.data.network.model.ANError;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView, I extends MvpInteractor> {

    void onAttach(V mvpView);

    void onDetach();

    V getMvpView();

    I getInteractor();

    boolean isViewAttached();

    void checkViewAttached() throws BasePresenter.MvpViewNotAttachedException;

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}