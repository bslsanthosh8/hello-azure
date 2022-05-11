package com.org.wellsfargo.namepronunciation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEE1")
public class Employee1 {

    @Column(name = "id")
    @Id
    Integer id;

    @Column(name = "name")
    String name;

}
