package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import lombok.Data;

@Data
public class PersonData {
    private long personId;
    private String fullName;
    private String email;
    private String contact;

    public PersonData(long personId, PersonDTO personDTO) {
        this.personId = personId;
        this.fullName = personDTO.fullName;
        this.email = personDTO.email;
        this.contact = personDTO.contact;
    }
}
