package com.n1rocket.framework.mvp.ui.bottom;

import com.n1rocket.framework.mvp.ui.base.MvpInteractor;
import com.n1rocket.framework.mvp.ui.base.MvpPresenter;
import com.n1rocket.framework.mvp.ui.base.MvpView;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface BottomContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {
        void onTabSentencesBottom();
        void onReTabSentencesBottom();
        void onTabProfileBottom();
        void onReTabProfileBottom();
    }

    interface View extends MvpView {
    }

    interface Interactor extends MvpInteractor {

    }

}
