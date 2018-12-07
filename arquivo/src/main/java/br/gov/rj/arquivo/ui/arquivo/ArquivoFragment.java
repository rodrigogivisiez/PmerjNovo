package br.gov.rj.arquivo.ui.arquivo;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;
import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.api.arquivo.Arquivo;
import br.gov.rj.arquivo.databinding.ArquivoFragmentBinding;
import br.gov.rj.arquivo.generic.GenericRecyclerAdapter;
import br.gov.rj.arquivo.generic.TypeProvider;
import br.gov.rj.arquivo.ui.arquivo.adapter.ArquivoViewHolderFactory;
import br.gov.rj.arquivo.util.OpenFragmentNavigation;
import br.gov.rj.arquivo.util.spinner.FactoryAdapter;

public class ArquivoFragment extends Fragment {

    private ArquivoViewModel mViewModel;
    RecyclerView recyclerView;

    public static ArquivoFragment newInstance() {
        return new ArquivoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArquivoFragmentBinding binding = ArquivoFragmentBinding.inflate(inflater, container, false);

        //binding.sesssetArmasdata(mViewModel.getConteudo());
        recyclerView =  binding.menuRecycler;
        recyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArquivoViewHolderFactory modelViewHolderFactory = new ArquivoViewHolderFactory();

        ArrayList<TypeProvider> lista = new ArrayList<>();
        lista.add(new Arquivo());

        GenericRecyclerAdapter adapter = new GenericRecyclerAdapter(lista, modelViewHolderFactory);
        recyclerView.setAdapter(adapter);
        //mViewModel.getModelShow().listaPastas.
        //recyclerView.setAdapter(FactoryAdapter.getAdapterRecyclerMenu(this, mViewModel.getArquivo()));

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(ArquivoViewModel.class);

        mViewModel.getRecentes();

        //mViewModel.getPastas();

        mViewModel.getArquivo();

        mViewModel.getArquivosByPasta("98");

        mViewModel.solicitaAcesso("9024");




        setupNavigation();
    }




    public void openDownloadToNavegator(){
        Uri uri = Uri.parse("https://portal.seseg.rj.gov.br/190/pmerj_api/arquivos/abrirArquivo/eyJzc24iOiIwNTI5OTM3NjcwNyIsImlkX2FycXVpdm8iOiI5MDI0IiwiaWRfcGFzdGEiOiI1NDAiLCJ0b2tlbiI6ImYxNmJhMzBhMTQ1ZDA2YTg1NTY1YjY0YTE2M2E5NzkxIn0=");
        Intent it  = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }


    private void setupNavigation() {
        mViewModel.getmNavigationDestino().observe(this, new OpenFragmentNavigation.DestinoObserver() {
            @Override
            public void onNewMessage(int snackbarMessageResourceId) {
                openDownloadToNavegator();

            }
        });
    }
}
