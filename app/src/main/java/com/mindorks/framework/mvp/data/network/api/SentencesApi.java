package com.mindorks.framework.mvp.data.network.api;

import com.mindorks.framework.mvp.data.network.model.SentenceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public interface SentencesApi {
    //@GET("/v2/5926ce9d11000096006ccb30")
    @GET("/v2/59f0fd53310000242c0ea0c3")
    Observable<SentenceResponse> loadSentences();
}
