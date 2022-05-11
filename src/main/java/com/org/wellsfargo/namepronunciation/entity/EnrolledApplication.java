package com.org.wellsfargo.namepronunciation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Enrolled_Application")
public class EnrolledApplication {


    @Column(name = "app_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENROLLMENT_APPLICATION_SEQUENCE")
    @SequenceGenerator(name = "ENROLLMENT_APPLICATION_SEQUENCE", sequenceName = "ENROLLMENT_APPLICATION_SEQUENCE", allocationSize = 1)
    Integer appId;
    @Column(name = "app_token")
    String appToken;
    @Column(name = "app_desc")
    String appDesc;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "created_timestamp")
    Date createdTimestamp;
    @Column(name = "modified_timestamp")
    Date modifiedTimestamp;
}
