/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;

/**
 *
 * @author tomek.buslowski
 */
public class MessageService {
    static private Map<Long, Message> messages = new HashMap<Long, Message>();
    static private MessageService instance;

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    private MessageService() {
        messages.put(1L, new Message(1L, "Pierwsza Wiadomość", "Jacek"));
        messages.put(2L, new Message(2L, "Druga Wiadomość", "Tomek"));
        messages.put(3L, new Message(3L, "Trzecia Wiadomość", "Adam"));
    }
    
    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }
    
    public Message getMessage(Long id) {
        return messages.get(id);
    }
    
    public Message createMessage(Message message) {
        message.setId(messages.size()+ 1L);
        messages.put(messages.size()+ 1L, message);
        
        return message;
    }
    
    public Message updateMessage(Message message) {
        messages.get(message.getId()).setAuthor(message.getAuthor());
        messages.get(message.getId()).setMessage(message.getMessage());
        
        return messages.get(message.getId());
    }
    
    public void deleteMessage(Long id) {
        messages.remove(id);
    }

    public List<Message> getAllMessagesStartingWith(String par1) {
        ArrayList<Message> foundedMessages = new ArrayList<>();
        par1 = par1.toLowerCase();
        for (Message message : messages.values()) {
            if( message.getMessage().toLowerCase().startsWith(par1)) {
                foundedMessages.add(message);
            }
        }
        return foundedMessages;
    }
    
}
