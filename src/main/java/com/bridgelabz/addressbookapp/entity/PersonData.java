package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address_book")
@Data
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private long personId;
    @Column(name = "fullName")
    private String fullName;
    private String gender;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String contact;
    private String address;
    private String city;
    private String state;
    private String zip;

    @ElementCollection
    @CollectionTable(name = "person_type", joinColumns = @JoinColumn(name="id"))
    @Column(name = "type")
    private List<String> types;

    public PersonData(PersonDTO personDTO) {

        this.fullName = personDTO.fullName;
        this.gender = personDTO.gender;
        this.email = personDTO.email;
        this.contact = personDTO.contact;
        this.address = personDTO.address;
        this.city = personDTO.city;
        this.state = personDTO.state;
        this.zip = personDTO.zip;
        this.types = personDTO.types;

    }

    public PersonData() {

    }
}
