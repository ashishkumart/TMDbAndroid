package net.mcnsolutions.tmdbandroid.ui.splash;

import android.os.Handler;

public class SpalshPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    public SpalshPresenter(SplashContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void decideNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.openMainActivity();
            }
        }, 3000);
    }

    @Override
    public void start() {

    }
}
