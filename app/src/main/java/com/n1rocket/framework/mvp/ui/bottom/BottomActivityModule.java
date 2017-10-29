package com.n1rocket.framework.mvp.ui.bottom;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abueno on 17/10/17.
 */

@Module
public class BottomActivityModule {

    //Main
    @Provides
    BottomContract.Interactor provideMainMvpInteractor(BottomInteractor interactor) {
        return interactor;
    }

    @Provides
    BottomContract.Presenter<BottomContract.View, BottomContract.Interactor> provideMainPresenter(
            BottomPresenter<BottomContract.View, BottomContract.Interactor> presenter) {
        return presenter;
    }

//    @Provides
//    BottomPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
//        return new BottomPagerAdapter(activity.getSupportFragmentManager());
//    }
}
