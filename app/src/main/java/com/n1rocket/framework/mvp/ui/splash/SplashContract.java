package com.n1rocket.framework.mvp.ui.splash;

import com.n1rocket.framework.mvp.ui.base.MvpInteractor;
import com.n1rocket.framework.mvp.ui.base.MvpPresenter;
import com.n1rocket.framework.mvp.ui.base.MvpView;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface SplashContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {

    }

    interface View extends MvpView {
        void openLoginActivity();

        void openMainActivity();

        void startSyncService();
    }

    interface Interactor extends MvpInteractor {
        int getCurrentUserLoggedInMode();
    }

}
