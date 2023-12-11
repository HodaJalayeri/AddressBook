package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookDaoFileImpl implements AddressBookDao {




    static Map<String, Address> addressBook;
    final String fileName;
    public AddressBookDaoFileImpl() {
        this.fileName = "adrressbook.txt";
        addressBook = new HashMap();
        try {
            // Check if the file exists
            if (!Files.exists(Path.of(fileName))) {
                // If not, create the file
                Path path = Paths.get(fileName);
                Files.createFile(path);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddressBookDaoFileImpl(String fileName) {
        this.fileName = fileName;
        addressBook = new HashMap();
        try {
            // Check if the file exists
            if (!Files.exists(Path.of(fileName))) {
                // If not, create the file
                Path path = Paths.get(fileName);
                Files.createFile(path);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, Address> getAddressBook() {
        return addressBook;
    }

    public List<Address> getAddressBookAsList(){
        return addressBook.values().stream().toList();
    }

    @Override
    public void addAddress(Address address) {
        addressBook.put(address.getLastName(), address);
    }

    @Override
    public Address removeAddress(String lastName) {
        Address address = findAddress(lastName);
      if (address != null){
          addressBook.remove(address.getLastName());
          return address;
      }
      else{
          return null;
      }
    }

    @Override
    public Address findAddress(String lastName) {
        if (addressBook.containsKey(lastName)) {
            Address address = addressBook.get(lastName);
            return address;
        } else {
            return null;
        }
    }


    @Override
    public int countOfAddresses() {
        return addressBook.size();
    }
    @Override
    public void saveAddressBook() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(addressBook);
            System.out.println("Address book saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAddressBook() {
        File file = new File(fileName);

        // Check if the file exists and is not empty
        if (file.exists() && file.length() > 0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                addressBook = (Map<String, Address>) ois.readObject();
            } catch (EOFException eofException) {
                System.out.println("Unexpected end of file. No address book data to load.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist or is empty. No address book data to load.");
        }
    }
}
