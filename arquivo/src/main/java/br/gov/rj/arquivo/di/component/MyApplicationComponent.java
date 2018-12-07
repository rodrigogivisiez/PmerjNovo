package br.gov.rj.arquivo.di.component;


import br.gov.rj.arquivo.DaggerApplication;
import br.gov.rj.arquivo.di.module.AppModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;


@Component(modules = { AndroidInjectionModule.class, AppModule.class})
public interface MyApplicationComponent extends AndroidInjector<DaggerApplication> {
    //void inject();
}