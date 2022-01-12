package com.bruk.learn_spring;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bruk.learn_spring.security.User;

import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date deadline;
    private boolean isCompleted;
    @ManyToOne
    private User user;
}
