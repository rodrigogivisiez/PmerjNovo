package br.gov.rj.arquivo.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.gov.rj.arquivo.ui.menu.MenuDevItem;


@Dao
public interface MenuDevItemDao {

    @Query("SELECT * FROM menu WHERE grupo =:id")
    List<MenuDevItem> getAll(int id);

    @Query("SELECT * FROM menu ")
    List<MenuDevItem> getByGroup();

    @Insert
    void insertAll(MenuDevItem... menuDevItems);

    @Delete
    void delete(MenuDevItem menuDevItem);

}
