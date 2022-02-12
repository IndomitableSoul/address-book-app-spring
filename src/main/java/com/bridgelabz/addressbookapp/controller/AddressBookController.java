package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.PersonDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.PersonData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Nikita Amar<amarnikita09@gmail.com>
 * @version :: Spring Boot :: (v2.6.3)
 */
@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO>  getAddessBook(){
        List<PersonData> addressBook = addressBookService.getAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping( "/{personId}")
    public ResponseEntity<ResponseDTO> getPersonDataById(@PathVariable("personId") long personId){
        PersonData personData = addressBookService.getPersonDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful at ID: " + personId, personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addPersonData(@Valid @RequestBody PersonDTO personDTO){
        PersonData personData = addressBookService.addPersonData(personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Person Data for: " + personDTO, personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updatePersonDataById(@PathVariable("personId") long personId, @Valid @RequestBody PersonDTO personDTO){
        PersonData personData = addressBookService.updatePersonDataById(personId, personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Person with id  " + personId, personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deletePersonDataById(@PathVariable("personId") long personId){
        PersonData personData = addressBookService.deletePersonDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Person with id  " + personId, personData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }


}
