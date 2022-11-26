package org.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serial;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "guide")
@NoArgsConstructor
@Data
public class Guide implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 9017118664546491038L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "salary", length = 45)
    private String salary;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_student")
    @ToString.Exclude
    private Student student;

    public Guide(String name, String salary, Student student) {
        this.name = name;
        this.salary = salary;
        this.student = student;
    }
}
