package com.mindorks.framework.mvp.ui.sentences;

import com.mindorks.framework.mvp.data.network.model.BlogResponse;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class SentencesFragmentModule {

    //Sentences
    @Provides
    SentencesMvpPresenter<SentencesMvpView, SentencesMvpInteractor> provideSentencesMvpPresenter(
            SentencesPresenter<SentencesMvpView, SentencesMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    SentencesAdapter provideSentencesAdapter() {
        return new SentencesAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    SentencesMvpInteractor provideSentencesMvpInteractor(SentencesInteractor interactor) {
        return interactor;
    }
}
