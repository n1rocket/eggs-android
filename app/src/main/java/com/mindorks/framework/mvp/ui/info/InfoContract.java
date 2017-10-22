package com.mindorks.framework.mvp.ui.info;

import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface InfoContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {
        void onSectionAClicked();
    }

    interface View extends MvpView {

    }

    interface Interactor extends MvpInteractor {

    }

}
