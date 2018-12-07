package br.gov.rj.arquivo.ui.arquivo.adapter;

import android.view.View;

import br.gov.rj.arquivo.generic.GenericViewHolder;
import br.gov.rj.arquivo.generic.ViewHolderFactory;

public class ArquivoViewHolderFactory implements ViewHolderFactory {
    @Override
    public int type() {
        return ArquivoViewHolder.LAYOUT;
    }

    @Override
    public GenericViewHolder createViewHolder(View parent) {
        return new ArquivoViewHolder(parent);
    }
}