package com.mindorks.framework.mvp.data.network.setup;

import com.mindorks.framework.mvp.data.network.api.LoginApi;
import com.mindorks.framework.mvp.data.network.api.ProfileApi;
import com.mindorks.framework.mvp.data.network.api.SentencesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Mohsen on 20/10/2016.
 */

@Module
public class ApiModule {
    @Provides
    @Singleton
    public SentencesApi provideSentencesApiService(Retrofit retrofit) {
        return retrofit.create(SentencesApi.class);
    }

    @Provides
    @Singleton
    public ProfileApi provideProfileApiService(Retrofit retrofit) {
        return retrofit.create(ProfileApi.class);
    }

    @Provides
    @Singleton
    public LoginApi provideLoginApiService(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }

}
