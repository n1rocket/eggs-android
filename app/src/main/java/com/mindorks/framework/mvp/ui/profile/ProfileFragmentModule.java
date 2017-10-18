package com.mindorks.framework.mvp.ui.profile;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class ProfileFragmentModule {

    //Profile
    @Provides
    ProfileMvpPresenter<ProfileMvpView, ProfileMvpInteractor> provideProfilePresenter(
            ProfilePresenter<ProfileMvpView, ProfileMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    ProfileMvpInteractor provideProfileMvpInteractor(ProfileInteractor interactor) {
        return interactor;
    }
}
