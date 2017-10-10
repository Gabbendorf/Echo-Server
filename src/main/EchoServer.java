package main;

import java.util.Scanner;

public class EchoServer {

    Scanner in = new Scanner(System.in);

    public void promptToType() {
        System.out.println("Hi! Please type anything:");
    }

    public String getWords() {
        return in.nextLine();
    }

    public void printReversedEcho(String usersWords) {
        System.out.println(new StringBuilder(usersWords).reverse().toString());
    }
}
