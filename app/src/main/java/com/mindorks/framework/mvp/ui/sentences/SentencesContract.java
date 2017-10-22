package com.mindorks.framework.mvp.ui.sentences;

import com.mindorks.framework.mvp.data.network.model.BlogResponse;
import com.mindorks.framework.mvp.ui.base.MvpInteractor;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by abuenoben on 22/10/17.
 */

public interface SentencesContract {
    interface Presenter<V extends MvpView,
            I extends MvpInteractor> extends MvpPresenter<V, I> {
        void onViewPrepared();
    }

    interface View extends MvpView {
        void updateBlog(List<BlogResponse.Blog> blogList);
    }

    interface Interactor extends MvpInteractor {
        Observable<BlogResponse> getBlogApiCall();
    }

}
