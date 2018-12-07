package br.gov.rj.arquivo.api.arquivo;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreparaSolicitacaoDownload {
    @SerializedName("token")
    @Expose
    String token;
    @SerializedName("ssn")
    @Expose
    String cpf;
    @SerializedName("id_pasta")
    @Expose
    String idPasta;
    @SerializedName("id_arquivo")
    @Expose
    String idArquivo;

    public PreparaSolicitacaoDownload(String token, String cpf, String idPasta, String idArquivo) {
        this.token = token;
        this.cpf = cpf;
        this.idPasta = idPasta;
        this.idArquivo = idArquivo;
    }


    public String getToken() {
        return token.trim();
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCpf() {
        return cpf.trim();
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdPasta() {
        return idPasta.trim();
    }

    public void setIdPasta(String idPasta) {
        this.idPasta = idPasta;
    }

    public String getIdArquivo() {
        return idArquivo.trim();
    }

    public void setIdArquivo(String idArquivo) {
        this.idArquivo = idArquivo;
    }


    private String convertUsingGson()
    {
        Gson gson = new Gson();
        String esteJson = gson.toJson(this);
        return esteJson;
    }

    private String convertBase64(String str){
        //String resultado = Base64.encodeToString(str.getBytes(),0);
        String resultado = Base64.encodeToString(str.getBytes(),Base64.URL_SAFE);
        //String resultado = Base64.URL_SAFE encodeToString(str.getBytes(),0);
        return resultado;
    }

    public String getPermissao(){
        String s = convertUsingGson();
        String result = convertBase64(s);
        return result;
    }


}
