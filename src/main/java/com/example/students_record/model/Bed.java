package com.example.students_record.model;

import com.example.students_record.enums.BedType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="beds")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Enumerated(EnumType.STRING)
    private BedType type;

//    @ManyToMany(mappedBy = "beds", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "bed", fetch = FetchType.LAZY)
    private Set<BedAssignment> students = new HashSet<BedAssignment>();

    public Set<BedAssignment> getStudents() {
        return students;
    }

    public void setStudents(Set<BedAssignment> students) {
        this.students = students;
    }

    public Bed(){}

    public Bed(String number, BedType type){
        this.type = type;
        this.number = number;
    }
//    public Set<Student> getStudents() {
//        return students;
//    }
//
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BedType getType() {
        return type;
    }

    public void setType(BedType type) {
        this.type = type;
    }

}
