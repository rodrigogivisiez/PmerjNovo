package br.gov.rj.arquivo.util.spinner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.gov.rj.arquivo.R;


public class AdapterSpinner extends BaseAdapter implements Filterable {
    private List<? extends SpinnerGeneric> lista;
    private List<SpinnerGeneric> listaGenerica;
    private List<SpinnerGeneric> listaGenericaFiltrada;
    private LayoutInflater mInflater;

    public AdapterSpinner(Context context, List<? extends SpinnerGeneric> results) {
        lista = results;
        mInflater = LayoutInflater.from(context);
        try {
            listaGenerica = (List<SpinnerGeneric>)results;
        }catch (Exception e){
            Log.e("givix"," error convert list to Spinner generic");
        }
    }

    @Override
    public int getCount() {
        if(lista == null){
            return 0;
        }else {
            return listaGenerica.size();
           // return lista.size();
        }
    }

    @Override
    public Object getItem(int i) {
        return listaGenerica.get(i);
        //return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.spinner_item, null);
            holder = new ViewHolder();
            holder.spinnerValue = (TextView) convertView.findViewById(R.id.spinner_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.spinnerValue.setText(listaGenerica.get(position).getDescricao());

       // holder.spinnerValue.setText(lista.get(position).getDescricao());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listaGenericaFiltrada = listaGenerica;
                } else {
                    List<SpinnerGeneric> filteredList = new ArrayList<>();
                    for (SpinnerGeneric row : listaGenerica) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getDescricao().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    listaGenericaFiltrada = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listaGenericaFiltrada;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listaGenericaFiltrada = (ArrayList<SpinnerGeneric>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }

    static class ViewHolder {
    TextView spinnerValue; //spinner name
}
}