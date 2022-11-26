package org.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Data
public class Student implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "student")
    @ToString.Exclude
    private Guide guide;
}