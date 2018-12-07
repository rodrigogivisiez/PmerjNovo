package br.gov.rj.arquivo.ui.arquivo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import br.gov.rj.arquivo.api.arquivo.Arquivo;
import br.gov.rj.arquivo.api.arquivo.Pasta;

public class ModelShow extends BaseObservable {

    List<Pasta> listaPastas;
    List<Arquivo> listaArquvivo;

    @Bindable
    public List<Pasta> getListaPastas() {
        return listaPastas;
    }

    public void setListaPastas(List<Pasta> listaPastas) {
        this.listaPastas = listaPastas;
        notifyPropertyChanged(BR.listaPastas);
    }
    @Bindable
    public List<Arquivo> getListaArquvivo() {
        return listaArquvivo;
    }

    public void setListaArquvivo(List<Arquivo> listaArquvivo) {
        this.listaArquvivo = listaArquvivo;
        notifyPropertyChanged(BR.listaArquvivo);
    }
}
