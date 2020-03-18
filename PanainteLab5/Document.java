/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanainteLab5;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Panainte
 */
public class Document implements Serializable{
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags ;

    public Document() {
    }

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void addTag(String key, Object obj) 
    {
        tags.put(key, obj);
    }

}