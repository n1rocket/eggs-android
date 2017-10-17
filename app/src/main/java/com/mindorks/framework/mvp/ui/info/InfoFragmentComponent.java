package com.mindorks.framework.mvp.ui.info;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Subcomponent(modules = InfoFragmentModule.class)
public interface InfoFragmentComponent extends AndroidInjector<InfoFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<InfoFragment> {
    }
}
