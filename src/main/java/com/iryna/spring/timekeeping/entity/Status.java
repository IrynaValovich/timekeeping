package com.iryna.spring.timekeeping.entity;

/**
 * @author iryna
 */
public enum Status {

    TODO("TODO"),
    PENDING("PANDING"),
    DONE("DONE");

    private String value;

    Status(String value){
        this.value = value;
    }
}
