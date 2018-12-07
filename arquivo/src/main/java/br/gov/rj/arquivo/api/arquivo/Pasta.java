package br.gov.rj.arquivo.api.arquivo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.gov.rj.arquivo.generic.TypeProvider;
import br.gov.rj.arquivo.generic.ViewHolderFactory;

public class Pasta implements TypeProvider {
    @SerializedName("id_Pasta")
    @Expose
    private String idPasta;
    @SerializedName("nome_pasta")
    @Expose
    private String nomePasta;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("pasta_pai")
    @Expose
    private String pastaPai;

    public String getIdPasta() {
        return idPasta;
    }

    public void setIdPasta(String idPasta) {
        this.idPasta = idPasta;
    }

    public String getNomePasta() {
        return nomePasta;
    }

    public void setNomePasta(String nomePasta) {
        this.nomePasta = nomePasta;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPastaPai() {
        return pastaPai;
    }

    public void setPastaPai(String pastaPai) {
        this.pastaPai = pastaPai;
    }

    @Override
    public int type(ViewHolderFactory viewHolderFactory) {
        return viewHolderFactory.type();
    }
}