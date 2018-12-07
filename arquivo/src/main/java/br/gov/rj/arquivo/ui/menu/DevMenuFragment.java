package br.gov.rj.arquivo.ui.menu;

import android.arch.lifecycle.ViewModelProviders;
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

import androidx.navigation.Navigation;
import br.gov.rj.arquivo.databinding.DevMenuFragmentBinding;
import br.gov.rj.arquivo.util.spinner.AdapterRecyclerMenu;
import br.gov.rj.arquivo.util.spinner.FactoryAdapter;


public class DevMenuFragment extends Fragment implements AdapterRecyclerMenu.RecyclerViewOnClickListenerHack {

    private DevMenuViewModel mViewModel;
    DevMenuFragmentBinding binding;
    RecyclerView recyclerView;
    String menu = "menu";
    //  NavController navController;
    public static DevMenuFragment newInstance() {
        return new DevMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if( getArguments().getString("menu") != null) {
            menu = getArguments().getString("menu");
            Log.e("menu - ", "->" + menu);

        }

        mViewModel = ViewModelProviders.of(this).get(DevMenuViewModel.class);

        binding = DevMenuFragmentBinding.inflate(inflater,
                container, false);

        recyclerView =  binding.menuRecycler;
        recyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(FactoryAdapter.getAdapterRecyclerMenu(this, mViewModel.getListMenu(menu)));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

//    @Override
//    public void onClickListener(View view, MenuDevItem item) {
//        Navigation.findNavController(view).navigate(item.getDestination());
//
//    }


    @Override
    public void onClickListener(View view, MenuDevItem item) {
        Navigation.findNavController(view).navigate(item.getDestination());
    }
}
