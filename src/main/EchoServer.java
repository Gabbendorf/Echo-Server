package main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class EchoServer {

    private PrintStream output;
    private Scanner input;

    public EchoServer(PrintStream output, InputStream input) {
        this.output = output;
        this.input = new Scanner(input);
    }

    public void run() {
        promptToType();
        printReversedEcho(getWords());
    }

    private void promptToType() {
        output.println("Hi! Please type anything:");
    }

    private String getWords() {
        String words = input.nextLine();
        while (words.length() == 0) {
            output.println("Please type at least 1 word:");
            words = input.nextLine();
        }
        return words;
    }

    private void printReversedEcho(String usersWords) {
        output.println(new StringBuilder(usersWords).reverse().toString());
    }
}
