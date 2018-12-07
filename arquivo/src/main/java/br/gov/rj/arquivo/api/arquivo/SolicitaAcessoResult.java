package br.gov.rj.arquivo.api.arquivo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SolicitaAcessoResult {

    @SerializedName("id_acessoArquivo")
    @Expose
    private String idAcessoArquivo;
    @SerializedName("token")
    @Expose
    private String token;

    public String getIdAcessoArquivo() {
        return idAcessoArquivo;
    }

    public void setIdAcessoArquivo(String idAcessoArquivo) {
        this.idAcessoArquivo = idAcessoArquivo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}