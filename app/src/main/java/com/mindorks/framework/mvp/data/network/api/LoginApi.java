package com.mindorks.framework.mvp.data.network.api;

import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.data.network.model.LogoutResponse;
import com.mindorks.framework.mvp.data.network.model.SentenceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public interface LoginApi {
    @GET("/v2/588d14f4100000a9072d2943")
    Observable<LoginResponse> loginGoogle();

    @GET("/v2/588d15d3100000ae072d2944")
    Observable<LoginResponse> loginFacebook();

    @GET("/v2/588d15f5100000a8072d2945")
    Observable<LoginResponse> loginServer();

    @GET("/v2/588d161c100000a9072d2946")
    Observable<LogoutResponse> logout();
}
