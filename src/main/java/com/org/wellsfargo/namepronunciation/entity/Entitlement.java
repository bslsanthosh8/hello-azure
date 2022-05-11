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
@Table(name = "ENTITLEMENT")
public class Entitlement {

    @Column(name = "entitlement_id")
    @Id
    Integer entitlementId;
    @Column(name = "entitlement_desc")
    String entitlement_desc;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "created_timestamp")
    Date createdTimestamp;
    @Column(name = "modified_timestamp")
    Date modifiedTimestamp;
}
