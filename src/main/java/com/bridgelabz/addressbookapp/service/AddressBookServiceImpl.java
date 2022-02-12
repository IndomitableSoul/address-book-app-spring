package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.entity.PersonData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IAddressBookService{
   List<PersonData> personDataList = new ArrayList<>();

    @Override
    public List<PersonData> getAddressBook() {
        return personDataList;
    }

    @Override
    public PersonData getPersonDataById(long personID) {
        return personDataList.get((int)personID-1);

    }

    @Override
    public PersonData addPersonData(PersonDTO personDTO) {
        PersonData personData = new PersonData(personDataList.size()+1, personDTO);
        if(personDataList.add(personData)) return personData;
        return null;
    }

    @Override
    public PersonData updatePersonDataById(long personId, PersonDTO personDTO) {
        PersonData personData = personDataList.get((int)personId-1);
        personData.setFullName(personDTO.fullName);
        personData.setEmail(personDTO.email);
        personData.setContact(personDTO.contact);
        return personData;
    }

    @Override
    public PersonData deletePersonDataById(long personID) {
        return personDataList.remove((int)personID-1);
    }
}
