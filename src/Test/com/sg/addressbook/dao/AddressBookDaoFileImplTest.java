package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookDaoFileImplTest {
    AddressBookDao testDao;
    String testFile = "testAddressBook.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new AddressBookDaoFileImpl(testFile);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void getAddressBookAsList() {
    }

    @Test
    public void addAddress() {
        Address address= new Address("John","MacDonald"," 7435 scout dr");
        testDao.addAddress(address);
        assertTrue(AddressBookDaoFileImpl.getAddressBook().containsKey(address.getLastName()));

    }

    @Test
    public void removeAddress() {
        Address address= new Address("Nik","JAL"," 655 Elk Dr");
        testDao.addAddress(address);
        testDao.removeAddress(address.getLastName());
        assertFalse(AddressBookDaoFileImpl.getAddressBook().containsKey(address.getLastName()));

    }

    @Test
    public void findAddress() {
        Address address= new Address("Maysam","Shah"," 512 Tribal Rd");
        testDao.addAddress(address);
        assertNotNull(testDao.findAddress(address.getLastName()));


    }

    @Test
    public void countOfAddresses() {
        assertEquals(testDao.countOfAddresses(), 0);
        Address address= new Address("Maysam","Shah"," 512 Tribal Rd");
        testDao.addAddress(address);
        assertEquals(testDao.countOfAddresses(), 1);

    }

    @Test
    public void saveAddressBook() throws IOException {
       assertEquals(Files.size(Path.of(testFile)),0);
       Address address= new Address("Maysam","Shah"," 512 Tribal Rd");
       testDao.addAddress(address);
       testDao.saveAddressBook();
       assertTrue(Files.size(Path.of(testFile))>0);

    }

    @Test
    public void loadAddressBook() throws IOException {
        saveAddressBook();
        testDao.loadAddressBook();
        assertTrue(AddressBookDaoFileImpl.getAddressBook().containsKey("Shah"));
    }
}