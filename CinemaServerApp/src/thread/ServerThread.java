package thread;

import domain.User;

import form.FrmMain;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private boolean active;
    private ServerSocket serverSocket;
    private final int port;
    private final FrmMain frmMain;
    private final List<ClientThread> clientThreads;
    private final List<User> already_logged;

    public ServerThread(FrmMain frmMain, int port) {
        this.frmMain = frmMain;
        this.port = port;
        active = true;
        clientThreads = new LinkedList<>();
        already_logged = new LinkedList<>();

    }

    @Override
    public void run() {
       
        try {
            serverSocket = new ServerSocket(port);
            frmMain.showStartupMessage();
            while (active) {
                Socket socket = serverSocket.accept();
                System.out.println("New client is connected!\n");
                ClientThread clientThread = new ClientThread(this, socket);
                clientThread.start();
                clientThreads.add(clientThread);
            }
        } catch (IOException ex) {
            frmMain.showShutDownMessage();
        }
        System.out.println("Server is stopped. Server is off.\n");
    }

    public void stopServer() {
        try {
            active = false;
            serverSocket.close();
            clientThreads.forEach(Thread::interrupt);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getAlreadyLogged() {
        return already_logged;
    }

  
    public void sendShutDownMessage() {
        for (ClientThread clientThread : clientThreads) {
            clientThread.sendShutDownMessage();
        }
    }

    

}
