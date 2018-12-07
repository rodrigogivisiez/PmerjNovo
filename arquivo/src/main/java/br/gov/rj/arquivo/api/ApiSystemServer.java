package br.gov.rj.arquivo.api;



import java.util.List;

import br.gov.rj.arquivo.Constantes;

import br.gov.rj.arquivo.api.arquivo.Arquivo;
import br.gov.rj.arquivo.api.arquivo.Pasta;
import br.gov.rj.arquivo.api.arquivo.SolicitaAcessoResult;
import br.gov.rj.arquivo.api.login.ResultAuthUser;
import br.gov.rj.arquivo.api.login.ResultValidaUsuario;
import br.gov.rj.arquivo.api.reset.EnviaEmailResponse;
import br.gov.rj.arquivo.api.reset.ResultResetSenhaEmail;
import br.gov.rj.arquivo.api.reset.TestaCpfResponse;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface ApiSystemServer {

    String NO_AUTH_HEADER_KEY = "NoAuthHeaderKey";

    /*
    ###############################################################################################################
    S   Y   S   T   E   M                        L   O   G   I   N
    ###############################################################################################################
     */
    @Headers("NoAuthHeaderKey: true")
    @FormUrlEncoded
    @POST(Constantes.API_SYSTEM + "/" +  Constantes.PATH_AUTHENTICATION + "/validaUsuario")
    Single<ResultValidaUsuario> ValidaUsuarioRx(
            @Field("usuario") String usuario
    );

    @Headers("NoAuthHeaderKey: true")
    @FormUrlEncoded
    @POST(Constantes.API_SYSTEM + "/" +  Constantes.PATH_AUTHENTICATION + "/redefinirSenhaEmail")
    Single<ResultResetSenhaEmail> RedefinirSenhaEmailRx(
            @Field("senha") String senha,
            @Field("confirma_senha") String confirma_senha,
            @Field("cpf") String cpf,
            @Field("tokenEmail") String tokenEmail
    );
    @Headers("NoAuthHeaderKey: true")
    @FormUrlEncoded
    @POST(Constantes.API_SYSTEM + "/authentication")
    Single<ResultAuthUser> AutenticaUsuarioRx(
            @Field("id") String idUsuario,
            @Field("senha") String senha,
            @Field("cpf") String cpfusuario
    );
    @Headers("NoAuthHeaderKey: true")
    @FormUrlEncoded
    @POST(Constantes.API_SYSTEM + "/" + Constantes.PATH_AUTHENTICATION + "/verificaCpfRedefinir")
    Single<TestaCpfResponse> VerificaCpfRedefinirRx(
            @Field("cpf") String cpf
    );
    @Headers("NoAuthHeaderKey: true")
    @FormUrlEncoded
    @POST(Constantes.API_SYSTEM + "/" +  Constantes.PATH_USUARIOS + "/enviarEmail")
    Single<EnviaEmailResponse> EnviaEmailRx(
            @Field("cpf") String cpf,
            @Field("email") String email,
            @Field("nome") String nome
    );
/*
    ###############################################################################################################
    A   P   I                           A R Q U I V O S
    ###############################################################################################################
*/

    @GET("190/pmerj_api/arquivos/getArquivosAcessoRapido")
    Single<List<Arquivo>> getRecentes();


    @GET("190/pmerj_api/arquivos/getPastasArvores")
    Single<List<Pasta>> getPastass();

    @GET("190/pmerj_api/arquivos/item_pasta/{pasta_id}")
    Single<List<Arquivo>> getArquivosByPasta(@Path("pasta_id") String pasta_id);


    @FormUrlEncoded
    @POST("190/pmerj_api/arquivos/solicitaAcesso")
    Single<List<SolicitaAcessoResult>> solicitarAcesso(
            @Field("id") String arquivo_id
    );

    @Streaming
    @GET("190/pmerj_api/arquivos/abrirArquivo/{dados}")
    Single<ResponseBody> abrirArquivo(
            @Path("dados") String dadosAcesso
    );

/*
    ###############################################################################################################
    A   P   I                           M O N I T O R
    ###############################################################################################################
*/

}
