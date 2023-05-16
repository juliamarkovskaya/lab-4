package com.github.rsoi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long idOfGood;
    int mark;
    int date;
}

