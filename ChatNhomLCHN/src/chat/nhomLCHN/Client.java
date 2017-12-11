/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.nhomLCHN;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.codehaus.jackson.map.ObjectMapper;

public class Client {
     public String address;
    public int port;
    
    public Client(){
        this.address = "localhost";
        this.port = 1997;
    }
    
    public Message sendMessage(Message m) throws Exception{
        try{
            Socket clientSocket = new Socket(this.address, this.port);
            
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(m);
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            Message mr = mapper.readValue(s1, Message.class);
            return mr;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Star client");
        String address = "Localhost";
        int port = 1997;
        try{
            Socket clientSocket = new Socket(address, port);
            
            OutputStream os = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            String s = "Like";
            oos.writeObject(s);
            oos.flush();
            
            InputStream is = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String s1 = (String)ois.readObject();
            System.out.println("Receive from server: " + s1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
