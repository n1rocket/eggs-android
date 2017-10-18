package com.mindorks.framework.mvp.di.builders;

import com.mindorks.framework.mvp.ui.info.InfoFragment;
import com.mindorks.framework.mvp.ui.info.InfoFragmentModule;
import com.mindorks.framework.mvp.ui.main.MainActivity;
import com.mindorks.framework.mvp.ui.main.MainActivityModule;
import com.mindorks.framework.mvp.ui.profile.ProfileFragment;
import com.mindorks.framework.mvp.ui.profile.ProfileFragmentModule;
import com.mindorks.framework.mvp.ui.sentences.SentencesFragment;
import com.mindorks.framework.mvp.ui.sentences.SentencesFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = InfoFragmentModule.class)
    abstract InfoFragment bindInfoFragment();

    @ContributesAndroidInjector(modules = ProfileFragmentModule.class)
    abstract ProfileFragment bindProfileFragment();

    @ContributesAndroidInjector(modules = SentencesFragmentModule.class)
    abstract SentencesFragment bindSentencesFragment();

}
