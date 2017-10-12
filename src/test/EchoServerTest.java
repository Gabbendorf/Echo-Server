package test;

import main.EchoServer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EchoServerTest {

    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    public void promptsToTypeSomething() {
        EchoServer echoServer = newEchoServerWith("");

        echoServer.promptToType();

        assertEquals("Hi! Please type anything:\n", output.toString());
    }


    @Test
    public void returnsUsersInput() {
        EchoServer echoServer = newEchoServerWith("hello");

        String usersInput = echoServer.getWords();

        assertEquals("hello", usersInput);
    }

    @Test
    public void emptyStringIsNotAccepted(){
        EchoServer echoServer = newEchoServerWith("\nhello");

        String usersInput = echoServer.getWords();

        assertEquals("Please type at least 1 word:\n", output.toString());
        assertEquals("hello", usersInput);
    }


    @Test
    public void printsReversedSingleWord() {
        EchoServer echoServer = newEchoServerWith("");

        echoServer.printReversedEcho("hello");

        assertEquals("olleh\n", output.toString());
    }

    @Test
    public void printsReversedMultipleWords() {
        EchoServer echoServer = newEchoServerWith("");

        echoServer.printReversedEcho("Hello World");

        assertEquals("dlroW olleH\n", output.toString());
    }

    private EchoServer newEchoServerWith(String input_string) {
        ByteArrayInputStream input = new ByteArrayInputStream(input_string.getBytes());

        return new EchoServer(new PrintStream(output), input);
    }
}
