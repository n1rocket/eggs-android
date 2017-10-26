package com.n1rocket.framework.mvp.data.network.model;

/**
 * Created by abuenoben on 24/10/17.
 */

public final class ANConstants {
    public static final int MAX_CACHE_SIZE = 10 * 1024 * 1024;
    public static final int UPDATE = 0x01;
    public static final String CACHE_DIR_NAME = "cache_an";
    public static final String CONNECTION_ERROR = "connectionError";
    public static final String RESPONSE_FROM_SERVER_ERROR = "responseFromServerError";
    public static final String REQUEST_CANCELLED_ERROR = "requestCancelledError";
    public static final String PARSE_ERROR = "parseError";
    public static final String NETWORK_ON_MAIN_THREAD_ERROR = "networkOnMainThreadError";
    public static final String PREFETCH = "prefetch";
    public static final String FAST_ANDROID_NETWORKING = "FastAndroidNetworking";
    public static final String USER_AGENT = "User-Agent";
    public static final String SUCCESS = "success";
}

