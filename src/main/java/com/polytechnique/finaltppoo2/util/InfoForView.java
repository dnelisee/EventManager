package com.polytechnique.finaltppoo2.util;

public class InfoForView {
    private String infoName;
    private String infoContent; 

    public InfoForView(String infoName, String infoContent) {
        this.infoName = infoName;
        this.infoContent = infoContent; 
    }

    public String getInfoName() {
        return infoName;
    }

    public String getInfoContent() {
        return infoContent;
    }
    
}
