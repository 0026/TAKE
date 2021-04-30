/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Tomasz
 */
public class Main {
    
    public static void main(String[] args){
    Client client = ClientBuilder.newClient();
    String count = client.target("http://localhost:8080/Complaints/" + "resources/complaints/count")
        .request(MediaType.TEXT_PLAIN).get(String.class);
    
    System.out.println("Count: " + count);
    
    String all= client.target("http://localhost:8080/Complaints/resources/complaints").request(MediaType.APPLICATION_JSON).get(String.class);
    System.out.println("All: " + all);
    
    String one= client.target("http://localhost:8080/Complaints/resources/complaints/652").request(MediaType.APPLICATION_JSON).get(String.class);
    System.out.println("One: " + one);
    
    one = one.replaceAll("\"status\":\"open\"", "\"status\":\"close\"");

    
    Response replace= client.target("http://localhost:8080/Complaints/resources/complaints/652")
            .request(MediaType.APPLICATION_JSON)
            .put(Entity.json(one));
    
    System.out.println("Status zmiany: " + replace.getStatus());
    
   
    String open= client.target("http://localhost:8080/Complaints/resources/complaints?status=open").request(MediaType.APPLICATION_JSON).get(String.class);
    System.out.println("Open: " + open);
    
    
    client.close(); 
    
    }
    
}
