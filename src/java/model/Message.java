/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomek.buslowski
 */
@XmlRootElement
public class Message {

    private long id;
    private String message;
    private Date created;
    private String author;

    private List<Link> links = new ArrayList<>();

    public Message() {
    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public Message(String message, String author) {
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String rel, String link) {
        Link newLink = new Link(rel, link);
        for (Link l : links) {
            if (l.getRel() == rel) {
                return;
            }
        }
        links.add(newLink);
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param creaated the created to set
     */
    public void setCreated(Date creaated) {
        this.created = creaated;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{ id: " + this.id + ", name: \"" + this.author + "\" }";
    }
    
    
}
