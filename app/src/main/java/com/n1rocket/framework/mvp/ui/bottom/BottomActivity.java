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

package com.n1rocket.framework.mvp.ui.bottom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.n1rocket.framework.mvp.R;
import com.n1rocket.framework.mvp.ui.base.BaseActivity;
import com.n1rocket.framework.mvp.ui.profile.ProfileFragment;
import com.n1rocket.framework.mvp.ui.sentences.SentencesFragment;
import com.roughike.bottombar.BottomBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by n1rocketdev on 25/05/17.
 */

public class BottomActivity extends BaseActivity implements BottomContract.View {

    @Inject
    BottomContract.Presenter<BottomContract.View, BottomContract.Interactor> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BottomActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {

        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        bottomBar.setOnTabSelectListener(tabId -> {
            if (tabId == R.id.tab_sentences) {
                mPresenter.onTabSentencesBottom();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, SentencesFragment.newInstance())
                        .commit();

            } else if (tabId == R.id.tab_profile) {
                mPresenter.onTabProfileBottom();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, ProfileFragment.newInstance())
                        .commit();

            }
        });

        bottomBar.setOnTabReselectListener(tabId -> {
            if (tabId == R.id.tab_sentences) {
                mPresenter.onReTabSentencesBottom();
            } else if (tabId == R.id.tab_profile) {
                mPresenter.onReTabProfileBottom();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
