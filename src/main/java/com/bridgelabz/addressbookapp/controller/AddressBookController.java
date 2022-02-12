package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String>  getAddessBook(){
        return new ResponseEntity<String>("Get Call Success",HttpStatus.OK);
    }

    @GetMapping( "/{personId}")
    public ResponseEntity<String> getPersonDataById(@PathVariable("personId") long personId){
        return new ResponseEntity<String>("Get Call Successful at ID: "+personId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addPersonData(@RequestBody PersonDTO personDTO){
        return new ResponseEntity<String>("Create Person Data for: "+personDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody PersonDTO personDTO){
        return new ResponseEntity<String>("Updated Person Data for: "+personDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("personId") long personId){
        return new ResponseEntity<String>("Deleted Person Data for: "+personId, HttpStatus.OK);
    }


}
