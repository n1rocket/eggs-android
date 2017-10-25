package com.mindorks.framework.mvp.data.network.api;

import com.mindorks.framework.mvp.data.network.model.ProfileResponse;
import com.mindorks.framework.mvp.data.network.model.SentenceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public interface ProfileApi {
    //@GET("/v2/5926ce9d11000096006ccb30")
    @GET("/v2/59f10617310000542e0ea0d9")
    Observable<ProfileResponse> loadProfile();
}
