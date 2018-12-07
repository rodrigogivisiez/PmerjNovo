package br.gov.rj.arquivo.util.spinner;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import br.gov.rj.arquivo.ui.menu.MenuDevItem;


public class FactoryAdapter {

    public static AdapterRecyclerMenu getAdapterRecyclerMenu(AdapterRecyclerMenu.RecyclerViewOnClickListenerHack r, List<MenuDevItem> results){
        return new AdapterRecyclerMenu(r, results);
    }


    public static AdapterRecycler getAdapterRecycler(AdapterRecycler.RecyclerViewOnClickListenerHack r, List<? extends  SpinnerGeneric> results){
        return new AdapterRecycler(r, results);
    }

    public static AdapterSpinner getAdapterSpinner(Context context, List<? extends  SpinnerGeneric> results){
        return new AdapterSpinner(context, results);
    }

//    public static ArrayAdapter getArrayAdapter(Context context){
//       return new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, SpinnerUtils.getOrgaosExpedidores());
//
//    }



//    void showDialogg() {
//        BoDialogFragment newFragment = new BoDialogFragment();
//        newFragment.show(getSupportFragmentManager(),
//                "add_photo_dialog_fragment");
//    }


}
