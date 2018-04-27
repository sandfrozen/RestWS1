/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.ArrayList;
import java.util.List;
import model.Message;

/**
 *
 * @author tomek.buslowski
 */
public class MessageService {
    private List<Message> list = new ArrayList<>();

    public MessageService() {
        Message m1 = new Message(1L, "Pierwsza wiadomość","Tomek");
        Message m2 = new Message(2L, "Druga wiadomość", "Jacek");
        Message m3 = new Message(3L, "Trzecia wiadomość","Adam");
        list.add(m1);
        list.add(m2);
        list.add(m3);
    }
    
    public List<Message> getAllMessages() {
        return list;
    }
    
    
}
