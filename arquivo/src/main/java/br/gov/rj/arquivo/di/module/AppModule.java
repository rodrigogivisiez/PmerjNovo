package br.gov.rj.arquivo.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.gov.rj.arquivo.DaggerApplication;
import br.gov.rj.arquivo.api.RequestTokenInterceptor;
import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {
    private final DaggerApplication application;

    public AppModule(DaggerApplication app) {
        this.application = app;
    }

    @Provides @Singleton
    Context providesApplicationContext(){
        return application;
    }

    @Provides @Singleton
    SharedPreferences providesSharedPreferences(Context app){
        return app.getSharedPreferences("My_Prefs_Title", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    RequestTokenInterceptor provideRequestTokenInterceptor(){
        return new RequestTokenInterceptor();
    }


//    @Provides
//    BoletimOcorrenciaVeiculoModel provideBoletimOcorrenciaVeiculoModel(){
//        BoletimOcorrenciaVeiculoModel bo = new BoletimOcorrenciaVeiculoModel();
//        bo.setId_boletim_ocorrencia_veiculo(333);
//        bo.setInformacao_complementar("dsfadfasdfasdf");
//        return bo;
//    }
//
//    @Provides
//    @Singleton
//    Context provideContext(Application application) {
//        return application;
//    }
//
//
//    @Provides
//    AppApiHelper provideAppApiHelper(AppApiHelper appApiHelper) {
//        return AppApiHelper.getInstance();
//    }
//    @Provides
//    @Singleton
//    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
//        HttpLoggingInterceptor interceptorLogging = new HttpLoggingInterceptor();
//        interceptorLogging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        return interceptorLogging;
//    }
//
//    @Provides
//    @Singleton
//   OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, RequestTokenInterceptor requestTokenInterceptor) {
//   return  new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(requestTokenInterceptor)
//                .build();
//    }
//
//
//    @Singleton @Provides
//    ApiServer provideApiService() {
//        return new Retrofit.Builder()
//                .baseUrl(Constantes.BASE_URL_PRODUCAO)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiServer.class);
//    }
//
//    @Singleton @Provides
//    ApiLogServer provideApiLogService() {
//        return new Retrofit.Builder()
//                .baseUrl(Constantes.BASE_URL_PRODUCAO)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiLogServer.class);
//    }
//
//    @Singleton @Provides
//    ApiPmerjServer provideApiPmerjService() {
//        return new Retrofit.Builder()
//                .baseUrl(Constantes.BASE_URL_PRODUCAO)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiPmerjServer.class);
//    }
//
//    @Singleton @Provides
//    ApiSystemServer provideApiSystemService() {
//        Log.e("dagger ","in providerApiSystemService");
//        return new Retrofit.Builder()
//                .baseUrl(Constantes.BASE_URL_PRODUCAO)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiSystemServer.class);
//    }

}
