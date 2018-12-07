package br.gov.rj.arquivo.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 20/05/2018.
 */

public class ResultValidaUsuario{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("userData")
    @Expose
    private UserData userData;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

}
