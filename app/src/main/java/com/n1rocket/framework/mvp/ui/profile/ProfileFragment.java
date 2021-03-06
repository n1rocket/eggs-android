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

package com.n1rocket.framework.mvp.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.n1rocket.framework.mvp.R;
import com.n1rocket.framework.mvp.data.network.model.ProfileResponse;
import com.n1rocket.framework.mvp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by n1rocketdev on 27/01/17.
 */

public class ProfileFragment extends BaseFragment implements ProfileContract.View {

    public static final String TAG = "ProfileFragment";

    @Inject
    ProfileContract.Presenter<ProfileContract.View, ProfileContract.Interactor> mPresenter;

    @BindView(R.id.imgEdit)
    ImageView imgEdit;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.action_text)
    TextView actionText;

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);

        return view;
    }

    @Override
    protected void setUp(View view) {
        mPresenter.onViewPrepared();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @OnClick(R.id.action_new_sentence)
    void onNewSentenceClicked(View v) {
        mPresenter.onNewSentenceClicked();
    }

    @Override
    public void updateProfile(ProfileResponse.Profile profile) {
        Glide.with(this)
                .load(profile.getCoverImgUrl())
                .asBitmap()
                .centerCrop()
                .into(imgEdit);

        titleText.setText(profile.getTitle());
        actionText.setText(profile.getDescription());

    }
}
