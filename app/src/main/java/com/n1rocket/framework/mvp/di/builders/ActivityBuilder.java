package com.n1rocket.framework.mvp.di.builders;

import com.n1rocket.framework.mvp.ui.bottom.BottomActivity;
import com.n1rocket.framework.mvp.ui.bottom.BottomActivityModule;
import com.n1rocket.framework.mvp.ui.login.LoginActivity;
import com.n1rocket.framework.mvp.ui.login.LoginActivityModule;
import com.n1rocket.framework.mvp.ui.main.MainActivity;
import com.n1rocket.framework.mvp.ui.main.MainActivityModule;
import com.n1rocket.framework.mvp.ui.splash.SplashActivity;
import com.n1rocket.framework.mvp.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = BottomActivityModule.class)
    abstract BottomActivity bindBottomActivity();

}
