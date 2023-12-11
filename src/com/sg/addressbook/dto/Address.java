package com.sg.addressbook.dto;

import com.sg.addressbook.dao.AddressBookDao;

import java.io.Serializable;

public class Address implements Serializable {
    String lastName;
    String firsName;
    String streetAddress;

    public Address(String firsName, String lastName, String streetAddress){
        this.firsName = firsName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
    }
    public String getLastName(){
        return lastName;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public String getFirsName(){
        return firsName;
    }

}
