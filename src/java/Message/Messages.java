/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CYRIL
 */
@ApplicationScoped

public class Messages {
    
    private int id;
    private String title;
    private String contents;
    private Date sentTime;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }
    

    public Messages() {
    }

    public Messages(int id, String title, String contents, Date sentTime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.sentTime = sentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
    
    
}
