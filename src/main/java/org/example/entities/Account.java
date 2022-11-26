package org.example.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "account", catalog = "example")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "balance")
    Integer balance;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @ToString.Exclude
    @JoinColumn(name = "client_id")
    Client client;

    public Account(Integer balance, Client client) {
        this.balance = balance;
        this.client = client;
    }
}
