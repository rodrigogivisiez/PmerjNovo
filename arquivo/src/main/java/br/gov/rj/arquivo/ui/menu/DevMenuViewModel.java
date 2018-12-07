package br.gov.rj.arquivo.ui.menu;


import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.gov.rj.arquivo.R;


public class DevMenuViewModel extends ViewModel {

    private List<MenuDevItem> listMenuMain;
    private List<MenuDevItem> listMenuDiversos;
    private List<MenuDevItem> listMenu;
    private List<MenuDevItem> listMenuComunicacao;
    private List<MenuDevItem> listMenuPmerj;
    private List<MenuDevItem> listMenuAreaRisco;
    private List<MenuDevItem> listMenuLocalizacao;

    public List<MenuDevItem> getListMenu(String menu_name) {

        listMenuMain = new ArrayList<MenuDevItem>();
//        listMenuMain.add(new MenuDevItem(R.drawable.ic_place_black_24dp,"Mapas", R.id.action_devMenuFragment_to_mapsFragment,"Veja os itens perto"));

        listMenuPmerj = new ArrayList<MenuDevItem>();
//        listMenuPmerj.add(new MenuDevItem(R.drawable.ic_action_home, "Escala", R.id.action_devMenuFragment_to_mapsFragment,"Mais descricao"));

        listMenuAreaRisco = new ArrayList<MenuDevItem>();
//        listMenuAreaRisco.add(new MenuDevItem(R.drawable.ic_action_home, "Contenção Armada", R.id.action_devMenuFragment_to_mapsFragment));

        listMenuComunicacao = new ArrayList<MenuDevItem>();
//        listMenuComunicacao.add(new MenuDevItem(R.drawable.ic_local_phone_black_24dp, "Telefones Funcionais", R.id.action_devMenuFragment_to_mapsFragment));

       listMenuLocalizacao = new ArrayList<MenuDevItem>();
//        listMenuLocalizacao.add(new MenuDevItem(R.drawable.ic_place_black_24dp, "Escolas", R.id.action_devMenuFragment_to_mapsFragment));

       listMenu = new ArrayList<MenuDevItem>();
       listMenu.add(new MenuDevItem(R.drawable.ic_launcher_background, "Arquivos", R.id.action_devMenuFragment_to_arquivoFragment));
       listMenu.add(new MenuDevItem(R.drawable.ic_launcher_background, "Monitor", R.id.action_devMenuFragment_to_monitorFragment));

        listMenuDiversos = new ArrayList<MenuDevItem>();
//        listMenuDiversos.add(new MenuDevItem(R.drawable.ic_action_home, "Identificação", R.id.action_devMenuFragment_to_mapsFragment));

        switch (menu_name){
            case "main" : return listMenuMain;
           // break;
            case "pmerj" : return listMenuPmerj;
           // break;
            case "arearisco" : return listMenuAreaRisco;
           // break;
            case "comunicacao" : return listMenuComunicacao;
           // break;
            case "localizacao" : return listMenuLocalizacao;
          //  break;
            case "diversos" : return listMenuDiversos;
          //  break;
            default: return listMenu;
          // break;
        }
    }

    public void setListMenu(List<MenuDevItem> listMenu) {
        this.listMenu = listMenu;
    }


}
