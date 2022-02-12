package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.entity.PersonData;

import java.util.List;
/**
 * @author Nikita Amar<amarnikita09@gmail.com>
 * @version :: Spring Boot :: (v2.6.3)
 */
public interface IAddressBookService {
    List<PersonData> getAddressBook();
    PersonData getPersonDataById(long personID);
    PersonData addPersonData(PersonDTO personDTO);
    PersonData updatePersonDataById(long personId, PersonDTO personDTO);
    PersonData deletePersonDataById(long personID);
}
