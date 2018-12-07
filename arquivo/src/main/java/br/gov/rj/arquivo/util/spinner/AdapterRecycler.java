package br.gov.rj.arquivo.util.spinner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.gov.rj.arquivo.R;


public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MviewHolder> {
    private static final String TAG = AdapterRecycler.class.getSimpleName();
    private List<?  extends SpinnerGeneric> lista;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public AdapterRecycler(RecyclerViewOnClickListenerHack r, List<? extends SpinnerGeneric> lista) {
        this.lista = lista;
        this.mRecyclerViewOnClickListenerHack = r;
    }

    public interface RecyclerViewOnClickListenerHack {
        public void onClickListener(View view, int position);
        //public void onLongPressClickListener(View view, int position);
    }


    @NonNull
    @Override
    public MviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_spinner_generic, viewGroup, false);
        MviewHolder mvh = new MviewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MviewHolder mviewHolder, int i) {
        mviewHolder.textView.setText(lista.get(i).getDescricao());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        public MviewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.genericSpinnerDescricao);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
