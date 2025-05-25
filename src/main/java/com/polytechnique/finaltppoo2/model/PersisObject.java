package com.polytechnique.finaltppoo2.model;

import java.util.HashMap;
import java.util.Map;

public abstract class PersisObject {
    protected String id; 

    public String getId() {
        return id;
    }

    /**
     * Map of attributes : "id" -> id, ...
     * To override. 
     */
    public Map<String, String> getAllAttributes() {
        Map<String, String> map = new HashMap<>();

        map.put("id", id); 

        return map;
    }
}
