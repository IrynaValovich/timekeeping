package com.iryna.spring.timekeeping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "start_date")
    // TODO find the way convert java.time into Timestamp in database and vice versa
    private LocalDate startDate;

    @Column(name = "end_date")
    // TODO find the way convert java.time into Timestamp in database and vice versa
    private LocalDate endDate;

    @Column(name = "duration")
    // TODO find the way make duration field valid for database
    private Duration duration;

    // TODO create relations with users-table
    //    rules: one user may have many activities and one activity can be run by many
    //    users at the same time
    private List<User> users;


}
