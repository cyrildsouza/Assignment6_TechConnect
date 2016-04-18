/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;



/**
 *
 * @author CYRIL
 */
@ApplicationScoped
public class MessageController {
    
     List<Messages> messages = new ArrayList<>();
    

    public MessageController() {
        
        
        
    }
    
    public List<Messages> getMessages(){
        
        //List<Messages> mc = new ArrayList<>();
        
         Messages m1 = new Messages(1,"cool","hello",new Date());
         Messages m2 = new Messages(2,"hot", "hello",new Date());
         
        
         messages.add(m1);
         messages.add(m2);
        
          
   return messages ;
        
        
        
    }
    
    public Messages getMessageById(int id){
        
        
        Messages m1 = new Messages(1,"cool","hello",new Date());
         Messages m2 = new Messages(2,"hot","hello", new Date());
         
        
         messages.add(m1);
         messages.add(m2);
         
         for (Messages p : messages) {
            if (p.getId() == id) {
                
                return p;
            }
       }
         
        
         
         
//        JsonObjectBuilder message = Json.createObjectBuilder();
//        JsonArrayBuilder a = Json.createArrayBuilder();
//        JsonObjectBuilder mc = Json.createObjectBuilder();
//        
//        
//        for (Messages p : m) {
//            if (p.getId() == id) {
//                mc.add("id",p.getId());
//            mc.add("title",p.getTitle());
//            //mc.build();
//            }
//        }
//        
//        //for(int i=0;i<m.size();i++){
//            
//            
//            //mc.add("id",m.get(i).getId());
//            //mc.add("title",m.get(i).getTitle());
//            //mc.build();
//            //a.add(mc);
//        //}
//        //message.add("message", a);
//   JsonObject jo = mc.build();
   
   return null;
        
        
        
    }
    
    
   /* public JsonObject getMessageByDate(Da;te startDate,Date endDate,List<Messages> m){
        
        JsonObjectBuilder message = Json.createObjectBuilder();
        JsonArrayBuilder a = Json.createArrayBuilder();
        JsonObjectBuilder mc = Json.createObjectBuilder();
        
        
        for (Messages p : m) {
            if (p.getSentTime().before(endDate) && p.getSentTime().after(startDate)) {
                mc.add("id",p.getId());
            mc.add("title",p.getTitle());
            mc.add("sentTime",p.getSentTime().toString());
            //mc.build();
            }
        }
        
        //for(int i=0;i<m.size();i++){
            
            
            //mc.add("id",m.get(i).getId());
            //mc.add("title",m.get(i).getTitle());
            //mc.build();
            //a.add(mc);
        //}
        //message.add("message", a);
   JsonObject jo = mc.build();
   
   return jo;
        
        
        
    }*/
    
    public void addMessage(Messages m) {
        
        messages.add(m);
      
    }
    
     public Messages messageEdit(int id,JsonObject j){
        
       Messages m1 = new Messages(101,"cool","hello",new Date());
         Messages m2 = new Messages(201,"hot", "hello",new Date());
         
        
         messages.add(m1);
         messages.add(m2);
         
         for (Messages p : messages) {
            if (p.getId() == id) {
                
                p.setContents(j.getString("contents"));
                
                System.out.println("update message"+p.getContents());
                return p;
            }
            
         }
            return null;
       }
     
     public String messageDelete(int id){
        
       Messages m1 = new Messages(101,"cool","hello",new Date());
         Messages m2 = new Messages(201,"hot", "hello",new Date());
         
        
         messages.add(m1);
         messages.add(m2);
         
         for (Messages p : messages) {
            if (p.getId() == id) {
                
                messages.remove(p);
                
                System.out.println("removed");
                return "ok";
                
            }
            
         }
            return null;
       }

    public JsonObject getMessageByDate(Date startDate, Date endDate, List<Messages> msg) {
        
        JsonObjectBuilder message = Json.createObjectBuilder();
       JsonArrayBuilder a = Json.createArrayBuilder();
        JsonObjectBuilder mc = Json.createObjectBuilder();
        
        
        for (Messages p : msg) {
            if (p.getSentTime().before(endDate) && p.getSentTime().after(startDate)) {
                mc.add("id",p.getId());
            mc.add("title",p.getTitle());
            mc.add("contents",p.getContents());
            mc.add("sentTime",p.getSentTime().toString());
            //mc.build();
            }
        }
        
        //for(int i=0;i<m.size();i++){
            
            
            //mc.add("id",m.get(i).getId());
            //mc.add("title",m.get(i).getTitle());
            //mc.build();
            //a.add(mc);
        //}
        //message.add("message", a);
   JsonObject jo = mc.build();
   
   return jo;
        
    }
        
    
}
