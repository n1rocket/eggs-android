package com.mindorks.framework.mvp.ui.profile;

import com.mindorks.framework.mvp.ui.info.InfoFragment;
import com.mindorks.framework.mvp.ui.info.InfoFragmentModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Subcomponent(modules = ProfileFragmentModule.class)
public interface ProfileFragmentComponent extends AndroidInjector<ProfileFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProfileFragment> {
    }
}
