package br.gov.rj.arquivo.api;

import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static br.gov.rj.arquivo.api.ApiSystemServer.NO_AUTH_HEADER_KEY;


public class RequestTokenInterceptor implements Interceptor {
    String sessionToken;

    @Inject
    public RequestTokenInterceptor() {}

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        Log.e("givix","token setado" + sessionToken);
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        if (request.header(NO_AUTH_HEADER_KEY) == null) {
            // needs credentials
            if (sessionToken == null) {
               throw new RuntimeException("Session token should be defined for auth apis");
            } else {
               requestBuilder.addHeader("Authorization", "Bearer " + sessionToken);
            }
       }
        return chain.proceed(requestBuilder.build());
    }

}
