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

package com.n1rocket.framework.mvp.ui.sentences;

import com.n1rocket.framework.mvp.data.network.model.ANError;
import com.n1rocket.framework.mvp.data.network.model.SentenceResponse;
import com.n1rocket.framework.mvp.ui.base.BasePresenter;
import com.n1rocket.framework.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by n1rocketdev on 25/05/17.
 */

public class SentencesPresenter<V extends SentencesContract.View,
        I extends SentencesContract.Interactor> extends BasePresenter<V, I>
        implements SentencesContract.Presenter<V, I> {

    @Inject
    public SentencesPresenter(I mvpInteractor,
                              SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getInteractor()
                .getSentencesApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<SentenceResponse>() {
                    @Override
                    public void accept(@NonNull SentenceResponse sentenceResponse)
                            throws Exception {
                        if (sentenceResponse != null && sentenceResponse.getData() != null) {
                            getMvpView().updateSentences(sentenceResponse.getData());
                        }
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
