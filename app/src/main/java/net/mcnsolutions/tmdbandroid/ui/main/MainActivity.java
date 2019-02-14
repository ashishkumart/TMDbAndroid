package net.mcnsolutions.tmdbandroid.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.mcnsolutions.tmdbandroid.R;
import net.mcnsolutions.tmdbandroid.rest.ApiClient;
import net.mcnsolutions.tmdbandroid.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getToken();
            }
        });
    }

    private void getToken() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<String> tokenCall = apiInterface.getToken(ApiClient.API_KEY);
        tokenCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
