package com.example.android.feino;

import android.app.Application;
import com.example.android.feino.util.PreferenceHelper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;


@Module(includes = {})
 class AppModule {
    private Application app;

    AppModule(Application app) {
        this.app = app;
    }

    @Singleton
    @Provides
    PreferenceHelper providesHelper() {
        return new PreferenceHelper(app);
    }

}
