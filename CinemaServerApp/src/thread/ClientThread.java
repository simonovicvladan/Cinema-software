package thread;

import controller.Controller;
import domain.CinemaHall;
import domain.GeneralEntity;
import domain.Member;
import domain.Movie;
import domain.Projection;
import domain.Reservation;
import domain.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

public class ClientThread extends Thread {

    private Socket socket;
    private ServerThread serverThread;

    public ClientThread(ServerThread serverThread, Socket socket) {
        this.socket = socket;
        this.serverThread = serverThread;
    }

    @Override
    public void run() {
        System.out.println("Client thread is executing..");
        try {
            handleRequest();
        } catch (IOException | ClassNotFoundException ex) {
//            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Client has disconnected. Socket is closed.\n\n");
    }

    private void handleRequest() throws IOException, ClassNotFoundException {
        while (!isInterrupted()) {
            System.out.println("Handling clients requests..\n");
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) inSocket.readObject();
            Response response = new Response();
            try {
                int operation = request.getOperation();
                System.out.println("\tOperation: " + operation);
                switch (operation) {

                    case Operation.OPERATION_LOGIN:
                        User userData = (User) request.getData();

                        GeneralEntity currentUser = Controller.getInstance().login(userData.getUsername(), userData.getPassword());
                        response.setStatus(ResponseStatus.OK);
//                        System.out.println(currentUser.toString());
                        response.setData(currentUser);
//                        serverThread.getAlreadyLogged().add((User) currentUser);
                        break;

                    case Operation.OPERATION_CREATE_MOVIE:
                        Movie movieData = (Movie) request.getData();
                        long movieID = Controller.getInstance().saveMovie(new LinkedList<>(Arrays.asList(movieData)));
                        response.setStatus(ResponseStatus.OK);
                        response.setData(movieID);
                        break;

                    case Operation.OPERATION_GET_ALL_MOVIES:
                        List<GeneralEntity> allMovies = Controller.getInstance().getAllMovies();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(allMovies);
                        break;

                    case Operation.OPERATION_SEARCH_MOVIES:
                        String keywordMovie = (String) request.getData();
                        List<GeneralEntity> movies = Controller.getInstance().getAllMovies(keywordMovie);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(movies);
                        break;

                    case Operation.OPERATION_DELETE_MOVIE:
                        Movie movie = (Movie) request.getData();
                        boolean successful = Controller.getInstance().deleteMovie(movie);
                        if (successful) {
                            response.setStatus(ResponseStatus.OK);
                        } else {
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        break;

                    case Operation.OPERATION_SAVE_ALL_CINEMA_HALLS:
                        List<CinemaHall> halls = (List<CinemaHall>) request.getData();
                        List<GeneralEntity> savedHalls = Controller.getInstance().saveAllHalls(halls);
                        response.setData(savedHalls);
                        response.setStatus(ResponseStatus.OK);
                        break;

                    case Operation.OPERATION_GET_ALL_CINEMA_HALLS:
                        List<GeneralEntity> allHalls = Controller.getInstance().getAllHalls();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(allHalls);
                        break;

                    case Operation.OPERATION_SEARCH_CINEMA_HALLS:
                        String keywordHall = (String) request.getData();
                        List<GeneralEntity> hallsFounded = Controller.getInstance().getAllHalls(keywordHall);
                        response.setData(hallsFounded);
                        response.setStatus(ResponseStatus.OK);
                        break;

                    case Operation.OPERATION_SAVE_MEMBER:
                        Member memberData = (Member) request.getData();
                        long createdMemberID = Controller.getInstance().saveMember(new LinkedList<>(Arrays.asList(memberData)));
                        response.setStatus(ResponseStatus.OK);
                        response.setData(createdMemberID);
                        break;

                    case Operation.OPERATION_GET_ALL_MEMBERS:
                        List<GeneralEntity> allMembers = Controller.getInstance().getAllMembers();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(allMembers);
                        break;

                    case Operation.OPERATION_SEARCH_MEMBERS:
                        String keywordMember = (String) request.getData();
                        List<GeneralEntity> membersFound = Controller.getInstance().getAllMembers(keywordMember);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(membersFound);
                        break;

                    case Operation.OPERATION_DELETE_MEMBER:
                        Member member = (Member) request.getData();
                        boolean successfulM = Controller.getInstance().deleteMember(member);
                        if (successfulM) {
                            response.setStatus(ResponseStatus.OK);
                        } else {
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        break;

                    case Operation.OPERATION_SAVE_ALL_PROJECTIONS:
                        List<Projection> projections = (List<Projection>) request.getData();
                        List<GeneralEntity> savedProjections = Controller.getInstance().saveAllProjections(projections);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(savedProjections);
                        break;

                    case Operation.OPERATION_GET_ALL_PROJECTIONS:
                        List<GeneralEntity> dbprojections = Controller.getInstance().getAllProjections();
                        response.setStatus(ResponseStatus.OK);
                        response.setData(dbprojections);
                        break;

                    case Operation.OPERATION_GET_ALL_PROJECTIONS_ORDERED:
                        String orderBy = (String) request.getData();
                        List<GeneralEntity> dbprojectionsOrdered = Controller.getInstance().getAllProjectionsOrdered(orderBy);
                        response.setStatus(ResponseStatus.OK);
                        response.setData(dbprojectionsOrdered);
                        break;

                    case Operation.OPERATION_SAVE_RESERVATION:
                        Reservation reservationData = (Reservation) request.getData();
                        long createdReservationID = Controller.getInstance().saveReservation(new LinkedList<>(Arrays.asList(reservationData)));
                        response.setStatus(ResponseStatus.OK);
                        response.setData(createdReservationID);
                        break;

                    case Operation.OPERATION_SAVE_ALL_RESERVATIONS:
                        List<Reservation> reservations = (List <Reservation>) request.getData();
                        Controller.getInstance().saveReservation(reservations);
                        response.setStatus(ResponseStatus.OK);
                        break;
                }

            } catch (Exception ex) {
//                ex.printStackTrace();
                response.setStatus(ResponseStatus.ERROR);
                response.setError(ex);
            }
            sendResponse(response);
        }
    }

    private void sendResponse(Response response) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(response);
    }

    public void sendShutDownMessage() {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(new Request(Operation.OPERATION_SHUTDOWN, null));
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
