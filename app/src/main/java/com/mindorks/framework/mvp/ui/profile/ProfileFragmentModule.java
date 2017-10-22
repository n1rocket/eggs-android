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
    ProfileContract.Presenter<ProfileContract.View, ProfileContract.Interactor> provideProfilePresenter(
            ProfilePresenter<ProfileContract.View, ProfileContract.Interactor> presenter) {
        return presenter;
    }

    @Provides
    ProfileContract.Interactor provideProfileMvpInteractor(ProfileInteractor interactor) {
        return interactor;
    }
}
