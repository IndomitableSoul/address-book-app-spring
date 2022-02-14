package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import lombok.Data;

import java.util.List;

@Data
public class PersonData {
    private long personId;
    private String fullName;
    private String gender;
    private String email;
    private String contact;
    private String address;
    private String city;
    private String state;
    private long zip;
    private List<String> types;

    public PersonData(long personId, PersonDTO personDTO) {
        this.personId = personId;
        this.fullName = personDTO.fullName;
        this.gender = personDTO.gender;
        this.email = personDTO.email;
        this.contact = personDTO.contact;
        this.address = personDTO.address;
        this.city = personDTO.city;
        this.state = personDTO.state;
        this.zip = personDTO.zip;
        this.types = personDTO.type;

    }
}
