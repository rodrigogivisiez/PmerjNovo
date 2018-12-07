package br.gov.rj.arquivo.util.spinner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.ui.menu.MenuDevItem;


public class AdapterRecyclerMenu extends RecyclerView.Adapter<AdapterRecyclerMenu.MviewHolder> {
    private static final String TAG = AdapterRecyclerMenu.class.getSimpleName();
    private List<MenuDevItem> lista;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public AdapterRecyclerMenu(RecyclerViewOnClickListenerHack r, List<MenuDevItem> lista) {
        this.lista = lista;
        this.mRecyclerViewOnClickListenerHack = r;
    }

    public interface RecyclerViewOnClickListenerHack {
        public void onClickListener(View view, MenuDevItem item);
        //public void onLongPressClickListener(View view, int position);
    }


    @NonNull
    @Override
    public MviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_menu_dev, viewGroup, false);
        MviewHolder mvh = new MviewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MviewHolder mviewHolder, int i) {
        MenuDevItem item = lista.get(i);
        mviewHolder.textView.setText(item.getDescricao());
        mviewHolder.txtTitulo.setText(item.getTitle());
        mviewHolder.icone.setImageResource(item.getIcone());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        TextView txtTitulo;
        ImageView icone;
        public MviewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.menu_descricao);
            txtTitulo = itemView.findViewById(R.id.menu_titulo);
            icone = itemView.findViewById(R.id.menu_icone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, lista.get(getPosition()));
            }
        }
    }
}
