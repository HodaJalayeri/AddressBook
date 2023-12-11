package com.sg.addressbook.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    @Override
    public void print(String msg) {
        System.out.print(msg);
    }
    @Override
    public int readInt() {
        Scanner inputReader= new Scanner(System.in);
        return inputReader.nextInt();
    }

    @Override
    public String readString() {
        Scanner inputReader= new Scanner(System.in);
        String input = inputReader.next();
        return input;
    }

    @Override
    public boolean doesHintEnter() {
        Scanner inputReader= new Scanner(System.in);

        String userInput = inputReader.nextLine();

        // Check if the user pressed Enter
        if (userInput.isEmpty()) {
            return true;
        }
        else return false;
    }
}
