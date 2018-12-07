package br.gov.rj.arquivo.api.reset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnviaEmailResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("dados")
    @Expose
    private String dados;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

}