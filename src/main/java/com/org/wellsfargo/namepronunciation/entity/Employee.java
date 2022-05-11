package com.org.wellsfargo.namepronunciation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEE")
public class Employee {

    @Column(name = "uid")
    @Id
    String uid;
    @Column(name = "emp_id")
    String empId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "middle_name")
    String middleName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "entitlement_id")
    Integer entitlementId;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "created_timestamp")
    Date createdTimestamp;
    @Column(name = "modified_timestamp")
    Date modifiedTimestamp;
}
