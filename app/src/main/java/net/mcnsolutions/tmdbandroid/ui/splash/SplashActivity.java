package net.mcnsolutions.tmdbandroid.ui.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.mcnsolutions.tmdbandroid.R;
import net.mcnsolutions.tmdbandroid.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SpalshPresenter(this);
        mPresenter.decideNextActivity();
    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
