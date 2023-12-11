package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;

public class AddressBookController {
    private AddressBookView view = new AddressBookView();
    private UserIO io = new UserIOConsoleImpl();
    private AddressBookDao dao = new AddressBookDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        io.print("Do you want to load address book from file (y/n)?\n");
        if (io.readString().equals("y"))
            dao.loadAddressBook();

        view.displayCreateAddressBanner();
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();
            switch (menuSelection) {
                case 1:
                    view.addAddress();
                    break;
                case 2:
                    view.deleteAddress();
                    break;
                case 3:
                    view.findAddress();
                    break;
                case 4:
                    view.coundAddress();
                    break;
                case 5:
                    view.displayAddressBookList(dao.getAddressBookAsList());
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
            io.print("Press 1 to go to Main Menu.\n");
            if (io.readInt() != 1) {
                keepGoing = false;
            }

        }
        io.print("Do you want to store address book in file (y/n)?");
        if (io.readString().equals("y"))
            dao.saveAddressBook();
    }


}
