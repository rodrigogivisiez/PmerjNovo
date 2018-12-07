package br.gov.rj.arquivo.di.component;

import javax.inject.Singleton;

import br.gov.rj.arquivo.di.module.AppModule;
import br.gov.rj.arquivo.ui.login.LoginnActivity;
import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    //void inject(DaggerApplication daggerApplication);
    void inject(LoginnActivity loginnActivity);

   // void inject(SharedViewModel sharedViewModel);
    //@Component.Builder
    //interface Builder {
        //AppComponent APP_COMPONENT();
        //@Binds
        //Application bindApplication(DaggerApplication app);
        //@BindsInstance
        //Builder application(Application application);
        //AppComponent build();
    //}
}
