package br.gov.rj.arquivo.util.NetworkUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import br.gov.rj.arquivo.Constantes;


/**
 * Created by Oto on 17/05/2018.
 */

public class NetworkUtils {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static String buildUrlAPIService(String caminho, String funcao) {
        Uri builtUri = Uri.parse(Constantes.BASE_URL)
                .buildUpon()
                .appendPath(Constantes.API_API)
                .appendPath(caminho)
                .appendPath(funcao)
                .build();
        String url = null;
        try {
            url = builtUri.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;

    }

    public static String ErrosdeConexaoRetrofit(Throwable t) {
        String erro = null;
        if (t instanceof ConnectException) {
            // logging probably not necessary
            Log.v("teste", "Verifique sua Conexão com a Internet");
            erro = "Verifique sua Conexão com a Internet";
            return erro;
        } else if (t instanceof SocketTimeoutException) {
            erro = "Está ocorrendo algum problema, entre em contato com o administrador do sistema";
            return erro;
        }
        erro = "nao identificado";
        return erro;


    }




}
