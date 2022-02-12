package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonDTO {

    public String fullName;
    public String email;
    public long contact;

}
