package br.gov.rj.arquivo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import br.gov.rj.arquivo.api.ApiSystemServer;
import br.gov.rj.arquivo.api.AppApiHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DevViewModel extends AndroidViewModel {

    private ApiSystemServer apiSystemServer;


    public DevViewModel(@NonNull Application application) {
        super(application);
        apiSystemServer = AppApiHelper.getApiSystemServer();
    }

    public void load() {

//        apiSystemServer.getContencaoArmada().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(resultContencaoArmadas -> {
//                    for (ResultContencaoArmada resultContencaoArmada : resultContencaoArmadas) {
//                        Log.e(" << Contencao Armada>> ", " - " + resultContencaoArmada.toString());
//                    }
//                        },throwable -> {
//                    Log.e("<< erro >>", "erro -> " + throwable.toString());
//                        }
//
//                );

    }





}
