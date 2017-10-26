package com.n1rocket.framework.mvp.di.builders;

import com.n1rocket.framework.mvp.ui.profile.ProfileFragment;
import com.n1rocket.framework.mvp.ui.profile.ProfileFragmentModule;
import com.n1rocket.framework.mvp.ui.sentences.SentencesFragment;
import com.n1rocket.framework.mvp.ui.sentences.SentencesFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = ProfileFragmentModule.class)
    abstract ProfileFragment bindProfileFragment();

    @ContributesAndroidInjector(modules = SentencesFragmentModule.class)
    abstract SentencesFragment bindSentencesFragment();

}
