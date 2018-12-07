package br.gov.rj.arquivo.ui.login;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import br.gov.rj.arquivo.MainActivity;
import br.gov.rj.arquivo.R;
import dagger.android.DaggerApplication;


public class LoginnActivity extends AppCompatActivity {

    SharedViewModel viewModel;
    ProgressDialog progressDialog;

//    @Inject
//    BoletimOcorrenciaVeiculoModel mbo ;

    @Inject
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  ((DaggerApplication)getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_loginn);
        progressDialog = new ProgressDialog(this);
        viewModel  = ViewModelProviders.of(this).get(SharedViewModel.class);

//        viewModel.loged.observe(this, aBoolean -> {
//            if(aBoolean){
//                Log.e("LoginActivity ---- ","true");
//                openActivity();
//            }
//                Log.e("LoginActivity ---- ","false");
//        }
//        );

//        viewModel.getNavigateToDetails().observe(this, new Observer() {
//            @Override
//            public void onChanged(@Nullable Object o) {
//                Log.e("givix", " get navigation to details in loggin activity");
//               openActivity();
//            }
//        });

    }


//    public void openActivity(){
//        Log.e("loginnActivity" , "open Activity -> Function");
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }


    public void ErrodeConexao(String MsgError) {
        progressDialog.dismiss();
        Toast.makeText(this, MsgError, Toast.LENGTH_SHORT).show();
    }

    public void ShowDialog(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void DismissDiaog(String message) {
        progressDialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
