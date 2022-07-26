package com.iryna.spring.timekeeping.entity;

/**
 * @author iryna
 */
public enum Category {

    STRATEGIC("STRATEGIC"),
    TACTIC("TACTIC"),
    ACCOUNTING("ACCOUNTING"),
    MARKETING("MARKETING"),
    PROCUREMENT("PROCUREMENT"),
    PUBLIC_RELATIONS("PUBLIC RELATIONS"),
    SALES("SALES"),
    FINANCIAL("FINANCIAL"),
    IT("IT"),
    ENGINEERING("ENGINEERING"),
    RISK_MANAGEMENT("RISK MANAGEMENT"),
    QUALITY("QUALITY"),
    CONTENT("CONTENT"),
    OTHER("OTHER");

    private String value;

    Category(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
