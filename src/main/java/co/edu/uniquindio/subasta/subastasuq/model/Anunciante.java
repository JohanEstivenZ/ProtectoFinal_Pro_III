package co.edu.uniquindio.subasta.subastasuq.model;

import java.util.ArrayList;

public class Anunciante {

    static ArrayList<Anuncio> listaAnuncios = new ArrayList<>();

    public static ArrayList<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }
}



