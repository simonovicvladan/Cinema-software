package controller;

import communication.Communication;
import domain.CinemaHall;
import domain.Member;
import domain.Movie;
import domain.Projection;
import domain.Reservation;
import domain.User;
import java.util.List;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.OPERATION_LOGIN, user);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (User) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Movie> getAllMovies() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_MOVIES);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Movie>) response.getData();
        }
        throw (Exception) response.getError();

    }

    public long saveMovie(Movie movie) throws Exception {
        Request request = new Request(Operation.OPERATION_CREATE_MOVIE, movie);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (long) response.getData();
        }
        throw (Exception) response.getError();
    }

    public void deleteMovie(Movie movie) throws Exception {
        Request request = new Request(Operation.OPERATION_DELETE_MOVIE, movie);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            System.out.println("Movie " + movie + " is removed from database.\n");
        } else {
            throw (Exception) response.getError();
        }
    }

    public void saveAllCinemaHalls(List<CinemaHall> halls) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_ALL_CINEMA_HALLS, halls);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            System.out.println("All cinema halls are saved!");
        } else {
            throw (Exception) response.getError();
        }
    }

    public List<CinemaHall> getAllHalls() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_CINEMA_HALLS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<CinemaHall>) response.getData();
        }
        throw (Exception) response.getError();
    }

    public List<CinemaHall> saveAllHalls(List<CinemaHall> halls) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SAVE_ALL_CINEMA_HALLS);
        request.setData(halls);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<CinemaHall>) response.getData();
        }
        throw (Exception) response.getError();
    }

    public long saveMember(Member member) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_MEMBER, member);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (long) response.getData();
        }
        throw (Exception) response.getError();
    }

    public List<Member> getAllMembers() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_MEMBERS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Member>) response.getData();
        }
        throw (Exception) response.getError();
    }

    public void deleteMember(Member member) throws Exception {
        Request request = new Request(Operation.OPERATION_DELETE_MEMBER, member);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            System.out.println("Member " + member + " is removed from database.\n");
        } else {
            throw (Exception) response.getError();
        }
    }

    public void saveProjections(List<Projection> projections) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_ALL_PROJECTIONS, projections);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            System.out.println("Projection list is saved!");
        } else {
            throw (Exception) response.getError();
        }
    }

    public List<Projection> getAllProjections() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_GET_ALL_PROJECTIONS);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Projection>) response.getData();
        }
        throw (Exception) response.getError();
    }

    public List<Projection> getAllProjections(String orderedBy) throws Exception {
        Request request = new Request();
        request.setData(orderedBy);
        request.setOperation(Operation.OPERATION_GET_ALL_PROJECTIONS_ORDERED);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Projection>) response.getData();
        }
        throw (Exception) response.getError();
    }

    public long saveReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_RESERVATION, reservation);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (long) response.getData();
        }
        throw (Exception) response.getError();
    }

    public void saveReservations(List<Reservation> reservations) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_ALL_RESERVATIONS, reservations);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            System.out.println("Reservation list is saved!");
        } else {
            throw (Exception) response.getError();
        }
    }

}
