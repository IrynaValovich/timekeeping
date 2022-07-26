package com.iryna.spring.timekeeping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author iryna
 */

/*
    TODO Activity Request entity
      rules: one request can be related with only one USER
            one request can have only one activity
            each request has to implement approve-cancel mechanism (perhaps enum or constants)
 */

@Entity
public class ActivityRequest {

    @Id
    private Long id;
}
