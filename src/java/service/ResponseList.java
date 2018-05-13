/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.Produkt;

/**
 *
 * @author tomek.buslowski
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
class ResponseList {
    
    @XmlElement(name = "produkty")
    private List<Produkt> list;

    public List<Produkt> getList() {
        return list;
    }

    public void setList(List<Produkt> list) {
        this.list = list;
    }
    
}
