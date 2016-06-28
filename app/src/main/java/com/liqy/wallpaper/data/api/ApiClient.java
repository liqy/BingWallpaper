package com.liqy.wallpaper.data.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liqy on 2016/6/27.
 */
public class ApiClient {

    private static final String API_URL = " https://api.ioliu.cn/";

    private static BingService tipSeeService;

    public static BingService getClient() {
        try {
            if (tipSeeService == null) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                return chain.proceed(chain.request());
                            }
                        }).build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                tipSeeService = retrofit.create(BingService.class);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        return tipSeeService;
    }
}
