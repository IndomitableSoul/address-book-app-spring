package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<PersonData, Long> {
}
