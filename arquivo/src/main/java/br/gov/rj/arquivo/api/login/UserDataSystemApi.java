package br.gov.rj.arquivo.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 21/06/2018.
 */

public class UserDataSystemApi {
    @SerializedName("ID_Usuario")
    @Expose
    private Integer iDUsuario;
    @SerializedName("functional_id")
    @Expose
    private Integer functionalId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ssn_number")
    @Expose
    private String ssnNumber;
    @SerializedName("IS_Admin")
    @Expose
    private Integer iSAdmin;

    public UserDataSystemApi(Integer iDUsuario, Integer functionalId, String name, String ssnNumber, Integer iSAdmin) {
        this.iDUsuario = iDUsuario;
        this.functionalId = functionalId;
        this.name = name;
        this.ssnNumber = ssnNumber;
        this.iSAdmin = iSAdmin;
    }

    public Integer getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Integer getFunctionalId() {
        return functionalId;
    }

    public void setFunctionalId(Integer functionalId) {
        this.functionalId = functionalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(String ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public Integer getISAdmin() {
        return iSAdmin;
    }

    public void setISAdmin(Integer iSAdmin) {
        this.iSAdmin = iSAdmin;
    }
}
