package com.example.android.feino;

import android.app.Application;
import dagger.Module;


@Module(includes = {})
 class AppModule {
    private Application app;

    AppModule(Application app) {
        this.app = app;
    }



}
