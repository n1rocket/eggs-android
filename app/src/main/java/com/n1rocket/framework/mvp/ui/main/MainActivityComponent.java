package com.n1rocket.framework.mvp.ui.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
