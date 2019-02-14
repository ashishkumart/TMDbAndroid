package net.mcnsolutions.tmdbandroid.rest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static String API_KEY = "4ce613c29769e6f1c1b5439229d5a3eb";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    // public static final String BASE_URL = "http://52.191.196.21:8080/api/";
    private static Retrofit authRetrofit = null;
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getAuthorizeClient(final String token) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .cacheControl(new CacheControl.Builder().noCache().build())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .cache(null).build();

        if (authRetrofit == null) {
            authRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(client).build();
        }
        return authRetrofit;
    }

    public static void destroyAuthClient() {
        authRetrofit = null;
    }
}

