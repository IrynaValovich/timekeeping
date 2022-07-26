package com.iryna.spring.timekeeping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author iryna
 */

/*
    TODO
            FRONTEND, LOGGING, VALIDATOR, DTO or whatever
          rules: one user may have only one account
             it means username, email and phone number must be unique
             if existed user tries to create new account with the same username/ email /
             phone number, he will get allert message:
              "User with such username/email/phone number already exists"
     */

    /*
    TODO implement roles: ADMIN and simple USER when reach Spring Security
     */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"activities", "activityRequests", "avatar", "password"})
@ToString(exclude = {"activities", "activityRequests", "password"})
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "unique_login_email_phone",
        columnNames = {"username", "phone", "email"})})
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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    // TODO think about this field
    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "users_activities", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activities;

    // TODO create relations with activities-requests table
    //     rules: one user may have many requests and request may have only one user
    //private List<ActivityRequest> activityRequests;
}
