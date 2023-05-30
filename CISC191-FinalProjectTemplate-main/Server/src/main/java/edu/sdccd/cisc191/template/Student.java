package edu.sdccd.cisc191.template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a student entity.
 */
@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    /**
     * Creates a new Student object with the specified name.
     *
     * @param name the name of the student
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return the name of the student
     */
    public String getName() {
        return name;
    }
}

