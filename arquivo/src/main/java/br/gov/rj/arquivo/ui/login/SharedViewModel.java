package br.gov.rj.arquivo.ui.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;

import javax.inject.Inject;

import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.api.ApiSystemServer;
import br.gov.rj.arquivo.api.AppApiHelper;
import br.gov.rj.arquivo.api.RequestTokenInterceptor;
import br.gov.rj.arquivo.api.login.ResultAuthUser;
import br.gov.rj.arquivo.api.login.ResultValidaUsuario;
import br.gov.rj.arquivo.api.reset.EnviaEmailResponse;
import br.gov.rj.arquivo.api.reset.ResultResetSenhaEmail;
import br.gov.rj.arquivo.api.reset.TestaCpfResponse;
import br.gov.rj.arquivo.util.OpenFragmentNavigation;
import br.gov.rj.arquivo.util.SingleLiveEvent;
import br.gov.rj.arquivo.util.SnackbarMessage;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SharedViewModel extends AndroidViewModel {

    private ApiSystemServer service;
    private Login login;
    private SingleLiveEvent navigateToDetails = new SingleLiveEvent();
    private SingleLiveEvent navigateToNext = new SingleLiveEvent();
    private Application application;
    private final SnackbarMessage mSnackbarText = new SnackbarMessage();
    private final OpenFragmentNavigation mNavigationDestino = new OpenFragmentNavigation();
    @Inject
    RequestTokenInterceptor requestTokenInterceptor;


    public SharedViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        login = new Login();
        loged = new MutableLiveData<Boolean>();
        service = AppApiHelper.getApiSystemServer();
    }

    public SingleLiveEvent getNavigateToNext() {
        return navigateToNext;
    }

    public MutableLiveData<Boolean> loged;

    public OpenFragmentNavigation getmNavigationDestino() {
        return mNavigationDestino;
    }

    public SingleLiveEvent getNavigateToDetails() {
        return navigateToDetails;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void logar(){
        login.setLoading(true);
       testaUsuarioParaLogin();

    }

    public void logimnbb() {
        login.setLoading(true);
        service.AutenticaUsuarioRx(login.getUsuarioId(),login.getSenha(),login.getCpf())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResultAuthUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //login.setLoading(false);
                       // mSnackbarText.setValue(R.string.usuario_incorreto);
                    }

                    @Override
                    public void onSuccess(ResultAuthUser resultAuthUser) {
                        login.setLoading(false);
                        if (!resultAuthUser.getError()){
                           // SharedPrefManager.getInstance(application).userLogin(resultAuthUser);
                            mSnackbarText.setValue(R.string.login_efetuado);
                            mNavigationDestino.setValue(R.id.action_loginFragment_to_devMenuFragment);
                            AppApiHelper.setToken(resultAuthUser.getToken());

                            navigateToDetails.call();
                           // mNavigationDestino.setValue();
                        }else{
                            mSnackbarText.setValue(R.string.senha_incorreta);
                            login.setSenha("");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        login.setLoading(false);
                        mSnackbarText.setValue(R.string.usuario_incorreto);
                    }
                });
    }

    public void resetEmail(){
        login.setLoading(true);
        service.VerificaCpfRedefinirRx(login.getCpf())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TestaCpfResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(TestaCpfResponse testaCpfResponse) {
                        login.setLoading(false);
                        if(!testaCpfResponse.getError()) {
                            login.setEmail(testaCpfResponse.getDados().get(0).getNMEmail());
                            login.setNome(testaCpfResponse.getDados().get(0).getNMEmail());
                            login.setCpf(testaCpfResponse.getDados().get(0).getNRCpf());
                            resetEnviarEmail();
                        }else{
                            mSnackbarText.setValue(R.string.email_nao_localizado);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        login.setLoading(false);
                        mSnackbarText.setValue(R.string.erro);
                    }
                });
    }

    public void resetEnviarEmail(){
        login.setLoading(true);
        service.EnviaEmailRx(login.getCpf(), login.getEmail(), login.getNome())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<EnviaEmailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(EnviaEmailResponse enviaEmailResponse) {
                        login.setLoading(false);
                        if(enviaEmailResponse.getError()){
                            mSnackbarText.setValue(R.string.erro);
                            return;
                        }
                        if(enviaEmailResponse.getDados().equals("OK")){
                            mSnackbarText.setValue(R.string.email_enviado_sucesso);
                            navigateToNext.call();
                            //mNavigationDestino.setValue(R.id.action_loginFragment_to_redefinirFragment);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        login.setLoading(false);
                        mSnackbarText.setValue(R.string.erro);
                    }
                });
    }

    public void resetSenhaTokenEmail(){
        login.setLoading(true);
        service.RedefinirSenhaEmailRx(login.getSenha(), login.getConfirmaSenha(), login.getCpf(), login.getTokenEmail())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResultResetSenhaEmail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ResultResetSenhaEmail resultResetSenhaEmail) {
                        login.setLoading(false);
                        if(resultResetSenhaEmail.getError()){
                            mSnackbarText.setValue(R.string.erro);
                            return;
                        }
                        if(resultResetSenhaEmail.getDados() == null){
                            mSnackbarText.setValue(R.string.senha_resetada_sucesso);
                            navigateToDetails.call();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        login.setLoading(false);
                        mSnackbarText.setValue(R.string.erro);
                    }
                });

    }

//    public void getPoliciaisFeridos(){
//        login.setLoading(true);
//        apiServer.getPmsFeridosRx()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        resultPmsFeridos -> {
//                            for (ResultPmsFerido x : resultPmsFeridos) {
//                                Log.e("givix ", "item " + x.toString());
//                            }
//                        },throwable -> {
//                        Log.e("givix ","error " + throwable.toString() );
//                }
//                );
//
//
////        service.getPmsFeridosRx()
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new SingleObserver<ResultPmsFerido>() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////
////                    }
////
////                    @Override
////                    public void onSuccess(ResultPmsFerido resultPmsFeridos) {
////                        login.setLoading(false);
////
////                    }
////
////
////                    @Override
////                    public void onError(Throwable e) {
////                        login.setLoading(false);
////                        mSnackbarText.setValue(R.string.erro);
////                    }
////                });
//
//    }

    public void testaUsuarioParaLogin() {
        login.setLoading(true);
        service.ValidaUsuarioRx(login.getCpf())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResultValidaUsuario>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onSuccess(ResultValidaUsuario resultValidaUsuario) {
                        login.setLoading(false);
                        if(!resultValidaUsuario.getError()) {
                            login.setEmail(resultValidaUsuario.getUserData().getEmail());
                            login.setUsuarioId(resultValidaUsuario.getUserData().getId());
                            logimnbb();
                        }else{
                            login.setCpf("");
                            login.setSenha("");
                            mSnackbarText.setValue(R.string.usuario_senha_incorreto);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        login.setLoading(false);
                        mSnackbarText.setValue(R.string.erro);
                        Log.e("server"," erro");
                    }
                });
    }

//    public void resetar(){
//        crudApiAuth.VerificaCpfToReset(login.getCpf());
//    }

    SnackbarMessage getSnackbarMessage() {
        return mSnackbarText;
    }

    public  class Login extends BaseObservable {

        private boolean loading;
        private String cpf;
        private String senha;
        private String confirmaSenha;
        private String email;
        private String nome;
        private String usuarioId;
        private boolean isLogged = false;
        private boolean esqueceuSenha = false;
        private String tokenEmail;

        @Bindable
        public String getTokenEmail() {
            return tokenEmail;
        }

        public void setTokenEmail(String tokenEmail) {
            this.tokenEmail = tokenEmail;
        }

        @Bindable
        public String getConfirmaSenha() {
            return confirmaSenha;
        }

        public void setConfirmaSenha(String confirmaSenha) {
            this.confirmaSenha = confirmaSenha;
            notifyPropertyChanged(BR.confirmaSenha);
        }

        public  Login() {

        }
        @Bindable
        public boolean isLoading() {
            return loading;
        }

        public void setLoading(boolean loading) {
            this.loading = loading;
            notifyPropertyChanged(BR.loading);
        }

        @Bindable
        public boolean getLogged() {
            return isLogged;
        }

        public void setLogged(Boolean logged) {
            isLogged = logged;
            notifyPropertyChanged(BR.logged);
        }

        @Bindable
        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
            notifyPropertyChanged(BR.cpf);
        }

        @Bindable
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
            notifyPropertyChanged(BR.email);
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Bindable
        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
            notifyPropertyChanged(BR.senha);
        }

        public String getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(String usuarioId) {
            this.usuarioId = usuarioId;
        }

        @Bindable
        public boolean getEsqueceuSenha() {
            return esqueceuSenha;
        }

        public void setEsqueceuSenha(boolean esqueceuSenha) {
            this.esqueceuSenha = esqueceuSenha;
            notifyPropertyChanged(BR.esqueceuSenha);
        }

        @Override
        public String toString() {
            String s = "\n";
            s+= cpf + "\n";
            s+= email + "\n";
            s+= usuarioId + "\n";
            s+= senha + "\n";
            return s;
        }
    }

}
