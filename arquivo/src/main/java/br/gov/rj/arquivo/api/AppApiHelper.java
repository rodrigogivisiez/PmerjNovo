package br.gov.rj.arquivo.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;


import br.gov.rj.arquivo.Constantes;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApiHelper {
    private static AppApiHelper appApiHelper = null;
    private static Retrofit retrofit = null;
    private static ApiSystemServer apiSystemServer = null;

    
    private static RequestTokenInterceptor requestTokenInterceptor;

    @Inject
    public AppApiHelper() {

    }

    public static AppApiHelper getInstance(){
        if(appApiHelper == null){
           appApiHelper = new AppApiHelper();
        }
        return appApiHelper;
    }

    public static void setToken(String token){
       requestTokenInterceptor.setSessionToken(token);
    }

    public static  Retrofit client(){
    if (retrofit == null) {

       // OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        HttpLoggingInterceptor interceptorLogging = new HttpLoggingInterceptor();
        interceptorLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        requestTokenInterceptor = new RequestTokenInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptorLogging)
                .addNetworkInterceptor(requestTokenInterceptor)
                .build();

       //sonBuilder gsonBuilder = new GsonBuilder();
       //sonBuilder.registerTypeAdapter(LatLng.class, new LatLngDeserializer());
       //son gson = gsonBuilder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }
        return retrofit;
}

    public static ApiSystemServer getApiSystemServer() {
        client();
        if(apiSystemServer == null){
            apiSystemServer = retrofit.create(ApiSystemServer.class);
        }
        return apiSystemServer;
    }
}
