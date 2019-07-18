package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;

public class Communication {

    private static Communication instance;
    private Socket socket;

    private Communication() {
    }

    public static Communication getInstance() throws IOException {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void sendRequest(Request request) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(request);
    }

    public Response readResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (Response) inSocket.readObject();
    }

    public void connect(String host, int port) throws IOException {
        System.out.println("Connecting to the server..\n");
        socket = new Socket(host, port);
        System.out.println("Communication to the server is available!");
        System.out.println("\n===============================================================\n\n");

    }

    public Socket getSocket() {
        return socket;
    }

}
