package com.org.wellsfargo.namepronunciation.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "NAME_PRONUNCIATION")
public class NamePronunciation {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_pronunciation_sequence")
    @SequenceGenerator(sequenceName = "name_pronunciation_sequence", allocationSize = 1, name = "name_pronunciation_sequence")
    Integer id;
    @Column(name = "uid")
    String uid;
    @Column(name = "pronunciation_sound")
    @Lob
    byte[] pronunciationSound;
    @Column(name = "format")
    String format;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "created_timestamp")
    Date createdTimestamp;
    @Column(name = "modified_timestamp")
    Date modifiedTimestamp;
}
