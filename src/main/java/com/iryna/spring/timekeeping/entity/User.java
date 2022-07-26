package com.iryna.spring.timekeeping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author iryna
 */

/*
    TODO
          rules: one user may have only one account
             it means username, email and phone number must be unique
             if existed user tries to create new account with the same username/ email /
             phone number, he will get allert message:
              "User with such username/email/phone number already exists"
     */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"activities", "activityRequests", "avatar"})
@ToString(exclude = {"activities", "activityRequests", "password"})
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "userIdSeq", sequenceName = "users_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "avatar")
    private String avatar;

    // TODO create relations with activities-table
    //    rules: one user may have many activities and one activity can be run by many
    //    users at the same time
    private List<Activity> activities;

    // TODO create relations with activities-requests table
    //     rules: one user may have many requests and request may have only one user
    private List<ActivityRequest> activityRequests;
}
