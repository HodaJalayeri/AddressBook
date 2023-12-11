package com.sg.addressbook.ui;

public interface UserIO {
    void print(String msg);

    int readInt();
    String readString();
    boolean doesHintEnter();
}
