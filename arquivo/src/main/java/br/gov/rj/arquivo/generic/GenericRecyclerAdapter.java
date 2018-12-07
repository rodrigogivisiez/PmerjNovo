package br.gov.rj.arquivo.generic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class GenericRecyclerAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private ArrayList<TypeProvider> items;
  //  private List<TypeProvider> items;

    private ViewHolderFactory viewHolderFactory;

    public GenericRecyclerAdapter(ArrayList<TypeProvider> items, ViewHolderFactory viewHolderFactory){

        this.items = items;
        this.viewHolderFactory = viewHolderFactory;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return viewHolderFactory.createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).type(viewHolderFactory);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}