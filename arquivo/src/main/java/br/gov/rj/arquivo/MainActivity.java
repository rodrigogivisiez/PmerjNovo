package br.gov.rj.arquivo;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private DevViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel  = ViewModelProviders.of(this).get(DevViewModel.class);

        // viewModel.load();
        setContentView(R.layout.activity_main);

    }

}
