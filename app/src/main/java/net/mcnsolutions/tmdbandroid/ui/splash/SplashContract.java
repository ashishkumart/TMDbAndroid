package net.mcnsolutions.tmdbandroid.ui.splash;

import net.mcnsolutions.tmdbandroid.BasePresenter;
import net.mcnsolutions.tmdbandroid.BaseView;

public interface SplashContract {
    interface View extends BaseView<Presenter> {
        void openMainActivity();
    }

    interface Presenter extends BasePresenter {
        void decideNextActivity();
    }
}
