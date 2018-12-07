package br.gov.rj.arquivo.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oto on 21/05/2018.
 */

public class ResultAuthUser {

    @SerializedName("error")
    @Expose
    private Boolean error;

   /* @SerializedName("msg")
    @Expose
    private String msg;*/

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("userData")
    @Expose
    private UserDataSystemApi userDataSystemApi;

    public ResultAuthUser(Boolean error, String msg) {
        this.error = error;
    }

    public ResultAuthUser(String token, UserDataSystemApi userDataSystemApi) {
        this.token = token;
        this.userDataSystemApi = userDataSystemApi;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDataSystemApi getUserData() {
        return userDataSystemApi;
    }

    public void setUserData(UserDataSystemApi userData) {
        this.userDataSystemApi = userData;
    }
}