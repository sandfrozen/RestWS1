/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tomek.buslowski
 */
public class Produkt {

    private String producent;
    private String nazwa;
    private int cena;

    public Produkt() {
    }

    public Produkt(String producent, String nazwa, int cena) {
        this.producent = producent;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

}
