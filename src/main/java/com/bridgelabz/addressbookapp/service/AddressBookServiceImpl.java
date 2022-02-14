package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.entity.PersonData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Amar<amarnikita09@gmail.com>
 * @version :: Spring Boot :: (v2.6.3)
 */

@Service
public class AddressBookServiceImpl implements IAddressBookService{

    @Autowired
    private ModelMapper modelMapper;

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


    //Used ModelMapper to map DTO to Entity
    @Override
    public PersonData updatePersonDataById(long personId, PersonDTO personDTO) {
        PersonData personData = personDataList.get((int)personId-1);
          modelMapper.map(personDTO, personData);
//        personData.setFullName(personDTO.fullName);
//        personData.setEmail(personDTO.email);
//        personData.setContact(personDTO.contact);
        return personData;
    }

    @Override
    public PersonData deletePersonDataById(long personID) {
        return personDataList.remove((int)personID-1);
    }
}
