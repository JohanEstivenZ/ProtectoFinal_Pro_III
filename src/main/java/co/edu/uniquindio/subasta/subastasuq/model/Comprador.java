package co.edu.uniquindio.subasta.subastasuq.model;

import java.util.ArrayList;

public class Comprador extends Persona {

    ArrayList<Puja> listaClientes = new ArrayList<>();

    public Comprador() {
    }

    public ArrayList<Puja> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Puja> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
