package com.mindorks.framework.mvp.ui.main;

import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface MainContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {

    }

    interface View extends MvpView {

    }

    interface Interactor extends MvpInteractor {

    }

}
