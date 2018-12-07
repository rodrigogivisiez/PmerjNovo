package br.gov.rj.arquivo.api.reset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TestaCpfResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("dados")
    @Expose
    private List<Dado> dados = new ArrayList<Dado>();

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Dado> getDados() {
        return dados;
    }

    public void setDados(List<Dado> dados) {
        this.dados = dados;
    }

}

