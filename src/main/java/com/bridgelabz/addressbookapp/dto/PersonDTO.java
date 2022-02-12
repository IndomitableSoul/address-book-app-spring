package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class PersonDTO {
    @NotEmpty(message="Person name cannot be empty")
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person name Invalid")
    public String fullName;
    @NotEmpty
    @Email
    public String email;
    @NotEmpty
    @Pattern(regexp = "(91 )[1-9]{1}[0-9]{9}", message = "Enter valid mobile number")
    public String  contact;

    public PersonDTO(String fullName, String email, String contact) {
        this.fullName = fullName;
        this.email = email;
        this.contact = contact;
    }
}
