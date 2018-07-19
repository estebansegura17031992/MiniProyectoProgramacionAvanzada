/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoprogramacionavanzada.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author esteban
 */
public class JsonObject {
    ArrayList elements;

    public JsonObject() {
    }
    
    public String convertToJson(Map<String,String> elements){
        String jsonString = "{";
        Iterator it = elements.keySet().iterator();
        if (!elements.isEmpty()) {
            String prevSeparador = "";
            while(it.hasNext()){
                String key = (String) it.next();
                jsonString = jsonString + prevSeparador +  "\""+key+"\"" + ":" + "\""+elements.get(key)+ "\"";
                prevSeparador = ",";
            }
        }
            
        jsonString = jsonString + "}";
        return jsonString;
    }
    
    
}
