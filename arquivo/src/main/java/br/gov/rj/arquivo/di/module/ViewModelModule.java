package br.gov.rj.arquivo.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.gov.rj.arquivo.ui.login.SharedViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel.class)
    abstract ViewModel bindSharedViewModel(SharedViewModel sharedViewModel);


//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}