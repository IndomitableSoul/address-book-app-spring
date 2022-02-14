package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class PersonDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Person name Invalid")
    public String fullName;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email Not Valid")
    public String email;

    @Pattern(regexp = "(91 )[1-9]{1}[0-9]{9}", message = "Enter valid mobile number")
    public String  contact;

    @Pattern(regexp = "^[0-9a-zA-Z,\\s -]{4,}$", message = "[Alphanumeric and , -] -> only allowed")
    public String address;

    @Pattern(regexp = "^[a-zA-Z\\s]{4,}$", message = "Enter Valid City name")
    public String city;

    @Pattern(regexp = "^[a-zA-Z\\s]{4,}$", message = "Invalid State name")
    public String state;
   // @Pattern(regexp = "^[1-9]{1}[0-9 \\s]{2,3}[0-9]{3}$", message = "Invalid Zip")
    public String zip;

    @NotNull(message = "type should not be Empty")
    public List<String> types;

    public PersonDTO(String fullName, String gender, String email, String contact,
                     String address, String city, String state, String zip, List<String> types) {
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.types = types;
    }
}
