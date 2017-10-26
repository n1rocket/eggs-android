package com.n1rocket.framework.mvp.ui.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class LoginActivityModule {

    //Login
    @Provides
    LoginContract.Presenter<LoginContract.View, LoginContract.Interactor> provideLoginPresenter(
            LoginPresenter<LoginContract.View, LoginContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
            LoginContract.Interactor provideLoginMvpInteractor(LoginInteractor interactor) {
        return interactor;
    }


}
