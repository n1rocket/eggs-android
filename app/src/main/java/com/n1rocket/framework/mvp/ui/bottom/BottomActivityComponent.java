package com.n1rocket.framework.mvp.ui.bottom;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Subcomponent(modules = BottomActivityModule.class)
public interface BottomActivityComponent extends AndroidInjector<BottomActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BottomActivity>{}
}
