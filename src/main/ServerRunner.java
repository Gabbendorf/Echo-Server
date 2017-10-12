package main;

public class ServerRunner {

    public static void main(String [] args) {
        EchoServer echoServer = new EchoServer(System.out, System.in);
        echoServer.run();
    }
}
