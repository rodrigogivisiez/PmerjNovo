package br.gov.rj.arquivo;

import android.app.Application;

import br.gov.rj.arquivo.di.component.AppComponent;
import br.gov.rj.arquivo.di.component.DaggerAppComponent;
import br.gov.rj.arquivo.di.module.AppModule;


public class DaggerApplication extends Application{
    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }
    private void initDagger() {
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getComponent() {
        return component;
    }

}
