package test;

import main.EchoServer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class EchoServerTest {

    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    public void promptsToTypeSomething() {
        EchoServer echoServer = newEchoServerWith("something");

        echoServer.run();

        assertTrue(output.toString().contains("Hi! Please type anything:"));
    }

    @Test
    public void emptyStringIsNotAccepted(){
        EchoServer echoServer = newEchoServerWith("\nhello");

        echoServer.run();

        assertTrue(output.toString().contains("Please type at least 1 word:"));
    }


    @Test
    public void printsReversedSingleWord() {
        EchoServer echoServer = newEchoServerWith("hello");

        echoServer.run();

        assertTrue(output.toString().contains("olleh"));
    }

    @Test
    public void printsReversedMultipleWords() {
        EchoServer echoServer = newEchoServerWith("Hello World");

        echoServer.run();

        assertTrue(output.toString().contains("dlroW olleH"));
    }

    private EchoServer newEchoServerWith(String input_string) {
        ByteArrayInputStream input = new ByteArrayInputStream(input_string.getBytes());

        return new EchoServer(new PrintStream(output), input);
    }
}
