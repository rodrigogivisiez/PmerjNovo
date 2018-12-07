package br.gov.rj.arquivo.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 06/06/2018.
 */

public class ResultDadosPessoaisPM {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("dadosPmPessoais")
    @Expose
    private UserDataCompleto userData;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public UserDataCompleto getDadosPmPessoais() {
        return userData;
    }

    public void setDadosPmPessoais(UserDataCompleto dadosPmPessoais) {
        this.userData = dadosPmPessoais;
    }

}