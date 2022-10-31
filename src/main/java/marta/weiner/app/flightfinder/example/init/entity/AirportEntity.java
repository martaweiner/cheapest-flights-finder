package marta.weiner.app.flightfinder.example.init.entity;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Entity
@Data
@Table(name = "Airports")
public class AirportEntity {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortname;
}
