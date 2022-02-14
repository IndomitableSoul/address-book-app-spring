package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class PersonDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person name Invalid")
    public String fullName;

    public String gender;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email Not Valid")
    public String email;

    @Pattern(regexp = "(91 )[1-9]{1}[0-9]{9}", message = "Enter valid mobile number")
    public String  contact;

    public String address;
    public String city;
    public String state;
    public long zip;
    public List<String> type;

    public PersonDTO(String fullName, String gender, String email, String contact,
                     String address, String city, String state, long zip, List<String> type) {
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
    }
}
