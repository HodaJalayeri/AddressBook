package com.sg.addressbook.ui;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;

import java.util.List;

public class AddressBookView {
    private UserIO io = new UserIOConsoleImpl();
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    public void displayCreateAddressBanner() {
        io.print("==========");
    }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:\n");
        io.print("\tPlease select the operation you wish to perform:\n");

        io.print("\t\t1. Add Address\n");
        io.print("\t\t2. Delete Address\n");
        io.print("\t\t3. Find Address\n");
        io.print("\t\t4. List Address Count\n");
        io.print("\t\t5. List All Address\n");

        return io.readInt();
    }

    public void addAddress() {
        io.print("Add Address Menu:\n");
        io.print("\tPlease Enter First Name:\n");
        String firstName = io.readString();
        io.print("\tPlease Enter Last Name:\n");
        String lastName = io.readString();
        io.print("\tPlease Enter Street Address:\n");
        String streetAddress = io.readString();
        Address address = new Address(firstName,lastName,streetAddress);
        dao.addAddress(address);

        io.print(".\n.\n.\n");
        io.print("Address Added. ");
    }

    public void deleteAddress() {
        io.print("Delete Address Menu:\n");
        io.print("\tPlease enter last name of address to delete:\n");
        String lastName = io.readString();
        Address address =  dao.removeAddress(lastName);
        if (address != null)
        {
            io.print(address.getStreetAddress() + "\n");
            io.print("\n");
            io.print("Really Deleted?");
            if (io.doesHintEnter())
            {
                dao.removeAddress(lastName);
                io.print("Address Deleted. ");
            }

        }
        else
            io.print("Address not found!");

    }

    public void findAddress() {
        io.print("Find Address Menu:\n");
        io.print("\tPlease enter last name of address to find:\n");
        String lastName = io.readString();
        Address address =  dao.findAddress(lastName);
        if (address != null)
        {
            io.print(address.getStreetAddress() + "\n");
            io.print("\n");

        }
        else
            io.print("Address not found!");
    }

    public void coundAddress() {
        io.print("List Address Count Menu:\n");
        io.print("\tThere are " + dao.countOfAddresses() + " addresses in the book.  Press 1 to go to Main Menu." +"\n");
    }


    public void displayAddressBookList(List<Address> addressBookList) {
        for (Address address : addressBookList) {
            String adressInfo = String.format("#%s : %s %s",
                    address.getFirsName(),
                    address.getLastName(),
                    address.getStreetAddress());
            io.print(adressInfo);
            io.print(".\n.\n.\n");
        }
    }

}
