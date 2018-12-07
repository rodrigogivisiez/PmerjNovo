
package br.gov.rj.arquivo.api.reset;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dado {

    @SerializedName("NR_Cpf")
    @Expose
    private String nRCpf;
    @SerializedName("NM_Email")
    @Expose
    private String nMEmail;
    @SerializedName("IS_Ativo")
    @Expose
    private Integer iSAtivo;
    @SerializedName("IS_PrimeiroAcesso")
    @Expose
    private Integer iSPrimeiroAcesso;
    @SerializedName("NM_usuario")
    @Expose
    private String nMUsuario;

    public String getNRCpf() {
        return nRCpf;
    }

    public void setNRCpf(String nRCpf) {
        this.nRCpf = nRCpf;
    }

    public String getNMEmail() {
        return nMEmail;
    }

    public void setNMEmail(String nMEmail) {
        this.nMEmail = nMEmail;
    }

    public Integer getISAtivo() {
        return iSAtivo;
    }

    public void setISAtivo(Integer iSAtivo) {
        this.iSAtivo = iSAtivo;
    }

    public Integer getISPrimeiroAcesso() {
        return iSPrimeiroAcesso;
    }

    public void setISPrimeiroAcesso(Integer iSPrimeiroAcesso) {
        this.iSPrimeiroAcesso = iSPrimeiroAcesso;
    }

    public String getNMUsuario() {
        return nMUsuario;
    }

    public void setNMUsuario(String nMUsuario) {
        this.nMUsuario = nMUsuario;
    }

}