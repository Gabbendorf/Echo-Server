package test;

import main.EchoServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EchoServerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String usersInput = "hello";
    private final InputStream stdin = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream(usersInput.getBytes()));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
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

        String usersInput = echoServer.getWords();

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
