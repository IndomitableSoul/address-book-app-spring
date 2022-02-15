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
        return addressBookRepository.findAll();
    }

    @Override
    public PersonData getPersonDataById(long personID) {
       return addressBookRepository.findById(personID)
               .orElseThrow(() -> new AddressBookException("Person with Id "+personID+ " does not exist...!!!"));
    }

    @Override
    public PersonData addPersonData(PersonDTO personDTO) {

        PersonData personData = modelMapper.map(personDTO, PersonData.class);
        log.debug("Person Data: "+personData.toString());
        return addressBookRepository.save(personData);
    }


    //Used ModelMapper to map DTO to Entity
    @Override
    public PersonData updatePersonDataById(long personId, PersonDTO personDTO) {

        PersonData personData = this.getPersonDataById(personId);
        modelMapper.map(personDTO, personData);
//        personData.setFullName(personDTO.fullName);
//        personData.setEmail(personDTO.email);
//        personData.setContact(personDTO.contact);
        return addressBookRepository.save(personData);
    }

    @Override
    public void deletePersonDataById(long personID) {
        PersonData personData = this.getPersonDataById(personID);
        addressBookRepository.delete(personData);
    }

    @Override
    public List<PersonData> findPersonCountByCity(String city) {
       return addressBookRepository.findPersonCountByCity(city);
    }

    @Override
    public Integer findPersonCountByState(String state) {
        return addressBookRepository.findPersonCountByState(state);
    }


}
