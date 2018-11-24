package com.example.android.feino;


import com.example.android.feino.activity.LoginActivity;
import com.example.android.feino.fragment.LoginFragment;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(LoginActivity activity);
    void inject(LoginFragment loginFragment);
}
