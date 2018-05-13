/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomek.buslowski
 */
@XmlRootElement
public class SearchParam {
    
    String nazwa;
    String producent;
    int cenaMniejszaNiz;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getCenaMniejszaNiz() {
        return cenaMniejszaNiz;
    }

    public void setCenaMniejszaNiz(int cenaMniejszaNiz) {
        this.cenaMniejszaNiz = cenaMniejszaNiz;
    }
    
}
