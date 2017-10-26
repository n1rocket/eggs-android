package com.n1rocket.framework.mvp.ui.sentences;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Subcomponent(modules = SentencesFragmentModule.class)
public interface SentencesFragmentComponent extends AndroidInjector<SentencesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SentencesFragment> {
    }
}
