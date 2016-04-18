/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author CYRIL
 */
@Path("messages")
@ApplicationScoped
public class MessageService {

    MessageController ct = new MessageController();
    List<Messages> msg = new ArrayList<>();
    int i= 0;
    boolean flag = false;
    //Messages mg = new Messages();
    
    @GET
    //@Path("{id}") 
    @Produces("application/json")    
    public String getAll() {
         
        
        JsonObjectBuilder message = Json.createObjectBuilder();
        JsonArrayBuilder a = Json.createArrayBuilder();
        JsonObjectBuilder mc = Json.createObjectBuilder();
        
        
        String json = "";
         
         System.out.println("AHKJAHDKJHAKDJHAK");
         
         
         msg = ct.getMessages();
         System.out.println("OOOOOOOOOOOOO"+msg);
         
         for (Messages ms : msg) {
            
                mc.add("id",ms.getId());
            mc.add("title",ms.getTitle());
            mc.add("senttime",ms.getSentTime().toString());
           
            a.add(mc);
            
        }
         message.add("message", a);
         JsonObject jo = message.build();
         System.out.println("QQQQQQQQQQQQQQQQQQQ"+jo);
        return jo.toString();
         
         
    }
    
    @GET
    @Path("/{id}") 
    @Produces("application/json")    
    public String getById(@PathParam("id") int id) {
        
        
        JsonObjectBuilder message = Json.createObjectBuilder();
      JsonArrayBuilder a = Json.createArrayBuilder();
      JsonObjectBuilder mc = Json.createObjectBuilder();
      
      Messages m = ct.getMessageById(id);
      
      mc.add("id",m.getId());
          mc.add("title",m.getTitle());
           mc.add("senttime",m.getSentTime().toString());
          JsonObject jo = mc.build();
          
          //mc.build();
      
      
//         System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
//        String json = "";
//         Messages m1 = new Messages(1,"cool",new Date());
//         Messages m2 = new Messages(2,"hot", new Date());
//         
//         
//         
//         msg.add(m1);
//         msg.add(m2);
//         
//         
//         JsonObject jo = c.getMessageById(id,msg);
//         
//         
return jo.toString();
         
         
    }
    
    @GET
    @Path("/{startDate}/{endDate}") 
    @Produces("application/json")    
    public String getByDate(@PathParam("startDate") Date startDate, @PathParam("endDate") Date endDate ) {
         
        String json = "";
         Messages m1 = new Messages(1,"cool","hello",new Date());
         Messages m2 = new Messages(2,"hot","hello",new Date());
         
         
         
         msg.add(m1);
         msg.add(m2);
         
         
         JsonObject jo = ct.getMessageByDate(startDate,endDate,msg);
         
         
        return jo.toString();
         
         
    }
    
    @POST
    @Consumes("application/json")    
    @Produces("application/json")
    public String add(String str) {
        JsonObject json = Json.createReader(new StringReader(str)).readObject();
        flag=true;
        if(flag){
            
            i++;
        }
        String t = json.getString("title");
        String c = json.getString("contents");
        Messages mg = new Messages(i,t,c,new Date());
        
        ct.addMessage(mg);
       //msg.add(mg);
       
       JsonObjectBuilder message = Json.createObjectBuilder();
      JsonArrayBuilder a = Json.createArrayBuilder();
      JsonObjectBuilder mc = Json.createObjectBuilder();
      
      
      
      mc.add("id",mg.getId());
          mc.add("title",mg.getTitle());
           mc.add("senttime",mg.getSentTime().toString());
          JsonObject jo = mc.build();
       // mg.setId(1);
       // mg.setTitle((json.getString("title")));
        
       // JsonObject jo = c.getMessageById(mg.getId(),msg);
      return jo.toString();
      
    }
    
    @PUT
    @Path("/{id}")
    @Consumes("application/json") 
    @Produces("application/json")
    public String edit(String str,@PathParam("id") int id) {
        
        
         System.out.println("ttttttttttttttttttttt");
        JsonObject json = Json.createReader(new StringReader(str)).readObject();
             
       
        
        
        JsonObjectBuilder message = Json.createObjectBuilder();
      JsonArrayBuilder a = Json.createArrayBuilder();
      JsonObjectBuilder mc = Json.createObjectBuilder();
      
      Messages m = ct.messageEdit(id, json);
      
      mc.add("id",m.getId());
          mc.add("title",m.getTitle());
          mc.add("contents",m.getContents());
           mc.add("senttime",m.getSentTime().toString());
          JsonObject jo = mc.build();
          
          return jo.toString();
          
      
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes("application/json") 
    @Produces("application/json")
    public Response delete(@PathParam("id") int id) {
        
        Response result;
        
             
       
        
        
       
      
      String st = ct.messageDelete(id);
      
        System.out.println(st);
        //  result = Response.ok().build();
         // System.out.println("dsfasfs"+result);
         // return result.toString();
          return   Response.status(200).entity(st).build();
          
      
    }
    
    
    }
    

