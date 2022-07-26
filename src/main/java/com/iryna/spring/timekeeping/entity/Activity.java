package com.iryna.spring.timekeeping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author iryna
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @SequenceGenerator(name = "activityIdSeq", sequenceName = "activities_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activityIdSeq")
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "start_time")
    // TODO find the way convert java.time into Timestamp in database and vice versa
    private LocalDateTime startTime;

    @Column(name = "end_time")
    // TODO find the way convert java.time into Timestamp in database and vice versa
    private LocalDateTime endTime;

    @Column(name = "duration")
    // TODO find the way make duration field valid for database
    private Duration duration;

    // TODO create relations with users-table
    //    rules: one user may have many activities and one activity can be run by many
    //    users at the same time

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "activities",
                cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<User> users;

    //TODO create relations with request table
    //    rules: one activity can have many requests but one request can have only one activity
    // private List<ActivityRequest> activityRequests;


}
