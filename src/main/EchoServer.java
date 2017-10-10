package main;

import java.util.Scanner;

public class EchoServer {

    Scanner in = new Scanner(System.in);

    public void promptToType() {
        System.out.println("Hi! Please type anything:");
    }

    public String getWords() {
        String words = in.nextLine();
        while (words.length() == 0) {
            System.out.println("Please type at least 1 word:");
            words = in.nextLine();
        }
        return words;
    }

    public void printReversedEcho(String usersWords) {
        System.out.println(new StringBuilder(usersWords).reverse().toString());
    }

}
