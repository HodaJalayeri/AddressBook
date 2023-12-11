package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;

import java.util.ArrayList;
import java.util.List;

public interface AddressBookDao {
    void addAddress(Address address);
    Address removeAddress(String lastName);
    Address findAddress(String lastName);
    int countOfAddresses();
    void saveAddressBook();
    void loadAddressBook();
    List<Address> getAddressBookAsList();

}
