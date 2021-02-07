package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id_student")
    private long idStudent;

    @Column(name = "student_full_name")
    private String studentFullName;

    @Column(name = "`group`")
    private int group;

    @Column(name = "year_of_admission")
    private int yearOfAdmission;
}
