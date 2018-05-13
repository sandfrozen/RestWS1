/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomek.buslowski
 */
public class Produkty {

    private List<Produkt> allProdukty;

    public Produkty() {
        allProdukty = new ArrayList<>();
        allProdukty.add(new Produkt("Dell", "Laptop", 2000));
        allProdukty.add(new Produkt("Logitech", "Myszka", 50));
        allProdukty.add(new Produkt("Dell", "Monitor", 1500));
        allProdukty.add(new Produkt("Dell", "Torba", 100));
        allProdukty.add(new Produkt("LG", "Tablet", 170));
        allProdukty.add(new Produkt("IBM", "Laptop", 2500));
    }

    public List<Produkt> getAllProdukty() {
        return allProdukty;
    }

    public List<Produkt> findProduktyByNazwaProducentCenaMniejszaNiz(String nazwa, String producent, int cenaMniejszaNiz) {
        List<Produkt> znalezioneProdukty = new ArrayList<>();
        if (nazwa == null || producent == null || cenaMniejszaNiz <= 0) {
            return znalezioneProdukty;
        }
        for (Produkt produkt : allProdukty) {
            if (produkt.getNazwa().toLowerCase().contains(nazwa.toLowerCase()) &&
                    produkt.getProducent().toLowerCase().contains(producent.toLowerCase()) &&
                    produkt.getCena() < cenaMniejszaNiz) {
                znalezioneProdukty.add(produkt);
            }
        }
        return znalezioneProdukty;
    }

}
