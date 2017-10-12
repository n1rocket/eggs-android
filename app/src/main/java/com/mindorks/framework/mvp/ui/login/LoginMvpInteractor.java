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

package com.mindorks.framework.mvp.ui.login;

import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.ui.base.MvpInteractor;

import io.reactivex.Observable;

/**
 * Created by n1rocketdev on 20/07/17.
 */

public interface LoginMvpInteractor extends MvpInteractor {

    Observable<LoginResponse> doServerLoginApiCall(
            LoginRequest.ServerLoginRequest request);

    Observable<LoginResponse> doGoogleLoginApiCall(
            LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(
            LoginRequest.FacebookLoginRequest request);
}
