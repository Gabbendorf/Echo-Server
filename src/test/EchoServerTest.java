package test;

import main.EchoServer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EchoServerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String usersInput = "\nhello";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream(usersInput.getBytes()));
    }

    @Test
    public void promptsToTypeSomething() {
        EchoServer echoServer = new EchoServer();

        echoServer.promptToType();

        assertEquals("Hi! Please type anything:\n", outContent.toString());
    }

    @Test
    public void returnsUsersInput() {
        EchoServer echoServer = new EchoServer();
        String input = "hello";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String usersInput = echoServer.getWords();

        assertEquals("hello", usersInput);
    }

    @Test
    public void emptyStringIsNotAccepted(){
        EchoServer echoServer = new EchoServer();
        String input = "\nhello";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String usersInput = echoServer.getWords();

        assertEquals("Please type at least 1 word:\n", outContent.toString());
        assertEquals("hello", usersInput);
    }

    @Test
    public void printsReversedSingleWord() {
        EchoServer echoServer = new EchoServer();

        echoServer.printReversedEcho("hello");

        assertEquals("olleh\n", outContent.toString());
    }

    @Test
    public void printsReversedMultipleWords() {
        EchoServer echoServer = new EchoServer();

        echoServer.printReversedEcho("Hello World");

        assertEquals("dlroW olleH\n", outContent.toString());
    }

}
