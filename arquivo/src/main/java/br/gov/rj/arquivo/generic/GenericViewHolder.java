package br.gov.rj.arquivo.generic;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericViewHolder<T> extends RecyclerView.ViewHolder{
    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T item);
}