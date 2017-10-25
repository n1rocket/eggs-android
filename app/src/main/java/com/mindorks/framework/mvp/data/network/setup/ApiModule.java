package com.mindorks.framework.mvp.data.network.setup;

import com.mindorks.framework.mvp.data.network.api.BlogApi;

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
    public BlogApi provideBlogApiService(Retrofit retrofit) {
        return retrofit.create(BlogApi.class);
    }

}
