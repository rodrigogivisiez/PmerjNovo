package br.gov.rj.arquivo.api.reset;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultResetSenhaEmail{

    @SerializedName("dados")
    @Expose
    private Object dados;
    @SerializedName("error")
    @Expose
    private Boolean error;

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

}