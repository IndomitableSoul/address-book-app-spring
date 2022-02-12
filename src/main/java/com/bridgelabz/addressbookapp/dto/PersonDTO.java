package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class PersonDTO {

    public String fullName;
    public String email;
    public long contact;

    public PersonDTO(String fullName, String email, long contact) {
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
    }
}
