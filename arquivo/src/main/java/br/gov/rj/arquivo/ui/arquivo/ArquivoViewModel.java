package br.gov.rj.arquivo.ui.arquivo;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.api.ApiSystemServer;
import br.gov.rj.arquivo.api.AppApiHelper;
import br.gov.rj.arquivo.api.arquivo.Arquivo;
import br.gov.rj.arquivo.api.arquivo.Pasta;
import br.gov.rj.arquivo.api.arquivo.PreparaSolicitacaoDownload;
import br.gov.rj.arquivo.util.OpenFragmentNavigation;
import br.gov.rj.arquivo.util.SingleLiveEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static android.support.constraint.Constraints.TAG;

public class ArquivoViewModel extends ViewModel {





    ModelShow modelShow = new ModelShow();

    public ModelShow getModelShow() {
        return modelShow;
    }

    public void setModelShow(ModelShow modelShow) {
        this.modelShow = modelShow;
    }

    private final OpenFragmentNavigation mNavigationDestino = new OpenFragmentNavigation();

    public OpenFragmentNavigation getmNavigationDestino() {
        return mNavigationDestino;
    }

    public void  getRecentes(){

        AppApiHelper
                .getApiSystemServer()
                .getRecentes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(arquivos -> {
                    for (Arquivo x : arquivos) {
                        Log.e(" Recente ->", "" + x.getNomeArquivo().toString());
                    }


                },throwable -> {
                    Log.e("ArquivoViewModel", "ocorreu um erro na consulta de arquivos rescentes");
                });
    }

    public void  getPastas(){

        AppApiHelper
                .getApiSystemServer()
                .getPastass()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pastas -> {
                    List<Pasta> diretorioRaiz = new ArrayList<>();
                    for (Pasta x : pastas) {
                        if(x.getPastaPai().equals("0"))diretorioRaiz.add(x);
                        Log.e(" Pasta ->", "" + x.getNomePasta().toString());
                    }

                    Log.e(" -> ", "XXXXXXXXXXXXXXXXXXX Painel de arquivos XXXXXXXXXXXXXXXXXXXXXXX" );
                    for (Pasta x : diretorioRaiz) {
                        Log.e(" -> XX Diretorio Raiz -", "" + x.getNomePasta().toString()) ;
                        for (Pasta y : pastas) {
                            if(y.getPastaPai().equals(x.getIdPasta()))
                            Log.e(" -> XX  subdiretorio ->", "" + y.getNomePasta().toString());
                        }
                    }
                    Log.e(" -> ", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" );




                },throwable -> {
                    Log.e("ArquivoViewModel", "ocorreu um erro na consulta de pastas arvore de arquivos");
                });
    }

    public void getArquivo(){

     //  PreparaSolicitacaoDownload arquivo = new PreparaSolicitacaoDownload("9760339f59e10b58db849ae15a765d31", "05299376707", "540","9019");
     //  Log.e("-> permissão => ", "" + arquivo.getPermissao());

    }

    public void  getArquivosByPasta(String pasta_id){


        AppApiHelper
                .getApiSystemServer()
                .getArquivosByPasta(pasta_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(arquivos -> {

                    for (Arquivo x : arquivos) {
                        Log.e("arquivos da item_pasta ->", pasta_id + x.getNomeArquivo());
                    }
                    //return arquivos;
                },throwable -> {

                    Log.e("ArquivoViewModel", "ocorreu um erro na consulta de arquivos por item_pasta");

                });
    }

    public void solicitaAcesso(String arquivo_id){
         AppApiHelper
                 .getApiSystemServer()
                 .solicitarAcesso(arquivo_id)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(solicitaAcessoResult -> {
                     Log.e("ArquivoViewModel ", " id_acesso_arquivo -> " + solicitaAcessoResult.get(0).getIdAcessoArquivo() + " token -> " + solicitaAcessoResult.get(0).getToken());

                    ///////////baixar arquivo ////////
                     PreparaSolicitacaoDownload arquivo = new PreparaSolicitacaoDownload(solicitaAcessoResult.get(0).getToken(), "05299376707", "540","9024");
                     String strToken = arquivo.getPermissao();
                     Log.e("-> permissão ppppp => ", "" + strToken);
                     String encodeURL= URLEncoder.encode( strToken, "UTF-8" );

                     mNavigationDestino.setValue(R.id.action_loginFragment_to_devMenuFragment);
                     //baixarArquivo(encodeURL);
                 },throwable -> {
                     Log.e("ArquivoViewModel ", " Erro na solicitação de acesso a arquivo" + throwable.getMessage().toString());

                 });
        
     }

    public void baixarArquivo(String tokenbyDownload){

        AppApiHelper
                .getApiSystemServer()
                .abrirArquivo(tokenbyDownload)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                    Log.e("ARQUIVO download ->" , "-> " + responseBody.source().toString());

                },throwable -> {
                    Log.e("ArquivoViewModel ", " Erro na solicitação de acesso a arquivo" + throwable.getMessage().toString());

                } );
    }

//    private boolean WriteResponseBodyToDisk(ResponseBody body) {
////
////        try {
////            // todo change the file location/name according to your needs
////            File futureStudioIconFile = new File(getExternalFilesDir(null) + File.separator + "Future Studio Icon.png");
////
////            InputStream inputStream = null;
////            OutputStream outputStream = null;
////
////            try {
////                byte[] fileReader = new byte[4096];
////
////                long fileSize = body.contentLength();
////                long fileSizeDownloaded = 0;
////
////                inputStream = body.byteStream();
////                outputStream = new FileOutputStream(futureStudioIconFile);
////
////                while (true) {
////                    int read = inputStream.read(fileReader);
////
////                    if (read == -1) {
////                        break;
////                    }
////
////                    outputStream.write(fileReader, 0, read);
////
////                    fileSizeDownloaded += read;
////
////                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
////                }
////
////                outputStream.flush();
////
////                return true;
////            } catch (IOException e) {
////                return false;
////            } finally {
////                if (inputStream != null) {
////                    inputStream.close();
////                }
////
////                if (outputStream != null) {
////                    outputStream.close();
////                }
////            }
////        } catch (IOException e) {
////            return false;
////        }
////    }
}
