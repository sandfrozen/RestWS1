/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient.sklep;

import java.net.ProxySelector;
import myclasses.Produkt;
import myclasses.ResponseList;
import myclient.Sklep;

/**
 *
 * @author tomek.buslowski
 */
public class RestProduktyClient {

    public static void main(String[] args) {
//        System.out.println("Start");
//        System.out.println("-------------------");
//        Sklep client = new Sklep();
//        ResponseList allProdukty = client.getAllProdukty(ResponseList.class);
//
//        for (Produkt p : allProdukty.getProdukty()) {
//            System.out.println(p.getNazwa());
//        }
//
//        System.out.println("-------------------");
//        System.out.println("End");

        ProxySelector.setDefault(new CustomProxySelector());
        System.out.println("Start");
        System.out.println("-------------------");
        Sklep client = new Sklep();
        ResponseList allProdukty = client.findProducts("", "d", 1800);

        for (Produkt p : allProdukty.getProdukty()) {
            System.out.println(p.getNazwa());
        }

        System.out.println("-------------------");
        System.out.println("End");

    }

}
