/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.nhomLCHN;

import org.codehaus.jackson.map.ObjectMapper;


public class Message {
     public String sender;
    public String receiver;
    public String type;
    public String content;
    
    public static void main(String[] argv){
        Message m1 = new Message();
        ObjectMapper mapper = new ObjectMapper();
        try{
            String jsonString = mapper.writeValueAsString(m1);
            System.out.println(jsonString);
            Message m1r = mapper.readValue(jsonString, Message.class);
            System.out.println("sender: " + m1r.sender);
            System.out.println("receiver: " + m1r.receiver);
            System.out.println("type: " + m1r.type);
            System.out.println("content: " + m1r.content);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
