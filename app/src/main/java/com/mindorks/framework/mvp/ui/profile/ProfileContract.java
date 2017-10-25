package com.mindorks.framework.mvp.ui.profile;

import com.mindorks.framework.mvp.data.network.model.ProfileResponse;
import com.mindorks.framework.mvp.data.network.model.SentenceResponse;
import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface ProfileContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {
        void onNewSentenceClicked();
        void onViewPrepared();
    }

    interface View extends MvpView {
        void updateProfile(ProfileResponse.Profile profile);
    }

    interface Interactor extends MvpInteractor {
        Observable<ProfileResponse> getProfileApiCall();
    }

}
