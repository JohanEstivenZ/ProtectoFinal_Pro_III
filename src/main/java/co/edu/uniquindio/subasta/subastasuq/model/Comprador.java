package co.edu.uniquindio.subasta.subastasuq.model;

import java.util.ArrayList;

public class Comprador {

    ArrayList<Puja> listaPujas = new ArrayList<>();

    public Comprador() {
    }

    public ArrayList<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(ArrayList<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }
}
