package br.gov.rj.arquivo.generic;

import android.view.View;

public interface ViewHolderFactory {
    int type();
    GenericViewHolder createViewHolder(View parent);
}