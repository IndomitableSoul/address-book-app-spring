package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.entity.PersonData;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressBookRepository addressBookRepository;

    List<PersonData> personDataList = new ArrayList<>();

    @Override
    public List<PersonData> getAddressBook() {
        return personDataList;
    }

    @Override
    public PersonData getPersonDataById(long personID) {
       return personDataList.stream().filter(personData -> personData.getPersonId() == personID).
                findFirst().orElseThrow(()->new AddressBookException("Person Not Found, Invalid Id"));
    }

    @Override
    public PersonData addPersonData(PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        log.debug("Person Data: "+personData.toString());
        return addressBookRepository.save(personData);
    }


    //Used ModelMapper to map DTO to Entity
    @Override
    public PersonData updatePersonDataById(long personId, PersonDTO personDTO) {

        PersonData personData = personDataList.stream().filter(person -> person.getPersonId() == personId).
                findFirst().orElseThrow(() -> new AddressBookException("Person Not Found, Invalid Id"));
        modelMapper.map(personDTO, personData);
//        personData.setFullName(personDTO.fullName);
//        personData.setEmail(personDTO.email);
//        personData.setContact(personDTO.contact);
        return personData;
    }

    @Override
    public PersonData deletePersonDataById(long personID) {
        personDataList.stream().filter(person -> person.getPersonId() == personID).
                findFirst().orElseThrow(()->new AddressBookException("Person Not Found, Invalid Id"));
        return personDataList.remove((int)personID-1);
    }
}
