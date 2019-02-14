package net.mcnsolutions.tmdbandroid.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("authentication/token/new")
    Call<String> getToken(@Query("api_key") String apiKey);
}
