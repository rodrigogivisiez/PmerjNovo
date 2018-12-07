package br.gov.rj.arquivo.util;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import br.gov.rj.arquivo.util.spinner.AdapterSpinner;
import br.gov.rj.arquivo.util.spinner.SpinnerGeneric;


public  class BindingUtil {

    private static SpinnerGeneric value;

    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(
                    editText.getContext()
                            .getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }
    }


    @InverseBindingAdapter(attribute = "selectedCountry", event = "selectedCountryAttrChanged")
    public static String bindCountryInverseAdapter(AppCompatSpinner pAppCompatSpinner) {
        Log.e("bind ","bind  qkkq");
        Object selectedItem = pAppCompatSpinner.getSelectedItem();
        SpinnerAdapter adapter = pAppCompatSpinner.getAdapter();
        if (adapter instanceof AdapterSpinner) {
            Log.e("bind ","bind  qkkq");
            return (String) selectedItem;
        }
        throw new UnsupportedOperationException("The adapter must be a CountrySpinnerAdapter");
    }



    @InverseBindingAdapter(attribute = "generic", event = "genericAttrChanged")
    public static Integer bindGenericInverseAdapter(Spinner spinner) {
        Log.e("bind ","bind  qkkq");
        if(spinner.getSelectedItem() instanceof SpinnerGeneric){
            SpinnerGeneric sG = (SpinnerGeneric)  spinner.getSelectedItem();
            Log.e("bind ","set generic id - > " + sG.getId());
            bindGenericValue(spinner, sG.getId());
            return sG.getId();
        }
        throw new UnsupportedOperationException("The adapter must be a CountrySpinnerAdapter");
    }

    @BindingAdapter(value = "genericAttrChanged", requireAll = false)
    public static void bindGenericChanged(Spinner spinner,  final InverseBindingListener newIntegerAttrChanged) {
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("bindGenericChanged ","valor alterado" + parent.getSelectedItem().toString());
                newIntegerAttrChanged.onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newIntegerAttrChanged.onChange();
            }
        };
        spinner.setOnItemSelectedListener(listener);
    }



    @BindingAdapter("generic")
    public static void bindGenericValue(Spinner spinner,  Integer value) {

       SpinnerAdapter adapter = spinner.getAdapter();
        Log.e("bindGenericValue","adapter " + value);
        if (adapter instanceof AdapterSpinner) {
            Log.e("bindGenericValue ","adapter equal Adaoter Spinner");
            Log.e("bindGenericValue ","adapter size -> " + adapter.getCount());
           AdapterSpinner adapterSpinner = (AdapterSpinner) adapter;



           if(value == null)return;

           for(int i=0; i <= adapter.getCount(); i++){
              if( adapter.getItem(i) instanceof SpinnerGeneric){
                  SpinnerGeneric a = (SpinnerGeneric) adapter.getItem(i);
                  if(a.getId() == value){
                      Log.e("bindGenericValue ","set value");
                      spinner.setSelection(i);
                      return;
                  }
              }
           }
            return;
        }
        throw new UnsupportedOperationException("The adapter must be a CountrySpinnerAdapter");
    }
//




}
