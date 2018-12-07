package br.gov.rj.arquivo.ui.menu;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(tableName = "menu")
public class MenuDevItem extends BaseObservable {
    @PrimaryKey
    private int id;
    private int icone;
    private String title;
    private int destination;
    private String descricao;
    private String grupo;

    @Ignore
    public MenuDevItem(int icone, String title, int destination, String descricao) {
        this.icone = icone;
        this.title = title;
        this.destination = destination;
        this.descricao = descricao;
    }

    /**
     *
     * @param icone
     * @param title
     * @param destination
     */


    @Ignore
    public MenuDevItem(int icone, String title, int destination) {
        this.icone = icone;
        this.title = title;
        this.destination = destination;
    }

    public MenuDevItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }


    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {


        return new ToStringBuilder(this)
                .append("icone ", icone)
                .append("title", title)
                .append("destination", destination)
                .append("descricao", descricao)
                .toString();
    }
}