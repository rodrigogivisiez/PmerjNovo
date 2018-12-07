package br.gov.rj.arquivo.api.arquivo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.gov.rj.arquivo.generic.TypeProvider;
import br.gov.rj.arquivo.generic.ViewHolderFactory;

public class Arquivo implements TypeProvider {

    @SerializedName("id_pasta")
    @Expose
    private String idPasta;
    @SerializedName("nome_pasta")
    @Expose
    private String nomePasta;
    @SerializedName("autorPasta")
    @Expose
    private String autorPasta;
    @SerializedName("dt_pasta")
    @Expose
    private String dtPasta;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("id_arquivo")
    @Expose
    private String idArquivo;
    @SerializedName("nome_arquivo")
    @Expose
    private String nomeArquivo;
    @SerializedName("autorArquivo")
    @Expose
    private String autorArquivo;
    @SerializedName("dt_arquivo")
    @Expose
    private String dtArquivo;
    @SerializedName("filesize")
    @Expose
    private String filesize;
    @SerializedName("IS_Ativo")
    @Expose
    private String iSAtivo;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("dataArquivo")
    @Expose
    private String dataArquivo;
    @SerializedName("formato")
    @Expose
    private String formato;

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

    public String getAutorPasta() {
        return autorPasta;
    }

    public void setAutorPasta(String autorPasta) {
        this.autorPasta = autorPasta;
    }

    public String getDtPasta() {
        return dtPasta;
    }

    public void setDtPasta(String dtPasta) {
        this.dtPasta = dtPasta;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(String idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getAutorArquivo() {
        return autorArquivo;
    }

    public void setAutorArquivo(String autorArquivo) {
        this.autorArquivo = autorArquivo;
    }

    public String getDtArquivo() {
        return dtArquivo;
    }

    public void setDtArquivo(String dtArquivo) {
        this.dtArquivo = dtArquivo;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getISAtivo() {
        return iSAtivo;
    }

    public void setISAtivo(String iSAtivo) {
        this.iSAtivo = iSAtivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataArquivo() {
        return dataArquivo;
    }

    public void setDataArquivo(String dataArquivo) {
        this.dataArquivo = dataArquivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public int type(ViewHolderFactory viewHolderFactory) {
        return viewHolderFactory.type();
    }
}