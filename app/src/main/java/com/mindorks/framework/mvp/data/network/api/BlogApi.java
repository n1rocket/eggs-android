package com.mindorks.framework.mvp.data.network.api;

import com.mindorks.framework.mvp.data.network.model.BlogResponse;
import com.mindorks.framework.mvp.data.network.model.OpenSourceResponse;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public interface BlogApi {
    @GET("/v2/5926ce9d11000096006ccb30")
    Observable<BlogResponse> loadBlogList();
}
