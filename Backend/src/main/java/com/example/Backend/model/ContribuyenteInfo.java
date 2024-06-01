package com.example.Backend.model;

public class ContribuyenteInfo {
    private boolean esContribuyente;

    public ContribuyenteInfo(boolean esContribuyente) {
        this.esContribuyente = esContribuyente;
    }

    public boolean isEsContribuyente() {
        return esContribuyente;
    }

    public void setEsContribuyente(boolean esContribuyente) {
        this.esContribuyente = esContribuyente;
    }
}