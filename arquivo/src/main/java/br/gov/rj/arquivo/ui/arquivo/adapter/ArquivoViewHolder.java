package br.gov.rj.arquivo.ui.arquivo.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.api.arquivo.Arquivo;
import br.gov.rj.arquivo.generic.GenericViewHolder;

public class ArquivoViewHolder extends GenericViewHolder<Arquivo> {

    public static final int LAYOUT = R.layout.item_arquivo;

    private ImageView imageArquivo;
    private TextView nome_arquivo;
    private TextView data_arquivo;
    private TextView tamanho_arquivo;


    public ArquivoViewHolder(View itemView) {
        super(itemView);
        imageArquivo = (ImageView) itemView.findViewById(R.id.imagem_arquivo);
        nome_arquivo = (TextView)itemView.findViewById(R.id.nome_arquivo);
        data_arquivo = (TextView)itemView.findViewById(R.id.data_arquivo);
        tamanho_arquivo = (TextView)itemView.findViewById(R.id.tamanho_arquivo);
    }

    @Override
    public void bind(Arquivo item) {
        imageArquivo.setImageResource(R.drawable.ic_picture_as_pdf_black_24dp);
        nome_arquivo.setText(item.getNomeArquivo());
        data_arquivo.setText(item.getDataArquivo());
        tamanho_arquivo.setText(item.getFilesize());
    }
}
