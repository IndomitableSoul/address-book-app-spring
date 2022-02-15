package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<PersonData, Long> {

    @Query(value = "select * from address_book where city = :city", nativeQuery = true)
    List<PersonData> findPersonCountByCity(String city);

    @Query(value = "select COUNT(*) from address_book where state = :state", nativeQuery = true)
    Integer findPersonCountByState(String state);

}
