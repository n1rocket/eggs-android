package com.mindorks.framework.mvp.ui.login;

import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

import io.reactivex.Observable;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface LoginContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {
        void onServerLoginClick(String email, String password);

        void onGoogleLoginClick();

        void onFacebookLoginClick();
    }

    interface View extends MvpView {
        void openMainActivity();

    }

    interface Interactor extends MvpInteractor {
        Observable<LoginResponse> doServerLoginApiCall(
                LoginRequest.ServerLoginRequest request);

        Observable<LoginResponse> doGoogleLoginApiCall(
                LoginRequest.GoogleLoginRequest request);

        Observable<LoginResponse> doFacebookLoginApiCall(
                LoginRequest.FacebookLoginRequest request);
    }

}
