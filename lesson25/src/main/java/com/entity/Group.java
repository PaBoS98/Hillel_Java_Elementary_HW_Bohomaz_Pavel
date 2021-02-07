package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "`groups`")
@Getter
@Setter
@ToString
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id_group")
    private long idGroup;

    @Column(name = "group")
    private String group;
}
