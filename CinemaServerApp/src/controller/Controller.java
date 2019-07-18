package controller;

import domain.CinemaHall;
import domain.GeneralEntity;
import domain.Member;
import domain.Movie;
import domain.Projection;
import domain.Reservation;
import domain.User;
import java.util.LinkedList;
import java.util.List;
import so.AbstractGenericOperation;
import so.cinemaHall.GetHallsSO;
import so.cinemaHall.SaveCinemaHallsSO;
import so.cinemaHall.SearchHallsSO;
import so.member.CreateMemberSO;
import so.member.DeleteMemberSO;
import so.member.GetMembersSO;
import so.member.SearchMembersSO;
import so.movie.CreateMovieSO;
import so.movie.DeleteMovieSO;
import so.movie.GetMoviesSO;
import so.movie.SearchMoviesSO;
import so.projection.GetProjectionsSO;
import so.projection.SearchProjectionsSO;
import so.projection.SaveProjectionsSO;
import so.reservation.CreateReservationSO;
import so.user.LoginUserSO;

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

    // ====================================================================
    // User operations
    public GeneralEntity login(String username, String password) throws Exception {
        AbstractGenericOperation so = new LoginUserSO();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        so.templateExecute(user, null);
        return ((LoginUserSO) so).getOne();
    }

    // ====================================================================
    // Movie operations
    public long saveMovie(LinkedList<Movie> movies) throws Exception {
        AbstractGenericOperation so = new CreateMovieSO();
        so.templateExecute(movies, null);
        return ((CreateMovieSO) so).getId();
    }

    public List<GeneralEntity> getAllMovies(String keywordMovie) throws Exception {
        AbstractGenericOperation so = new SearchMoviesSO();
        so.templateExecute(new Movie(), keywordMovie);
        return ((SearchMoviesSO) so).getList();
    }

    public List<GeneralEntity> getAllMovies() throws Exception {
        AbstractGenericOperation so = new GetMoviesSO();
        so.templateExecute(new Movie(), null);
        return ((GetMoviesSO) so).getList();
    }

    public boolean deleteMovie(Movie movie) throws Exception {
        AbstractGenericOperation so = new DeleteMovieSO();
        so.templateExecute(movie, null);
        return ((DeleteMovieSO) so).isSuccessful();
    }

    public List<GeneralEntity> saveAllHalls(List<CinemaHall> halls) throws Exception {
        AbstractGenericOperation so = new SaveCinemaHallsSO();
        so.templateExecute(halls, null);
        return ((SaveCinemaHallsSO) so).getHalls();
    }

    // ====================================================================
    // Cinema hall operations
    public List<GeneralEntity> getAllHalls() throws Exception {
        AbstractGenericOperation so = new GetHallsSO();
        so.templateExecute(new CinemaHall(), null);
        return ((GetHallsSO) so).getList();
    }

    public List<GeneralEntity> getAllHalls(String keywordHall) throws Exception {
        AbstractGenericOperation so = new SearchHallsSO();
        so.templateExecute(new CinemaHall(), keywordHall);
        return ((SearchHallsSO) so).getList();
    }

    // ====================================================================
    // Member operations
    public long saveMember(LinkedList<Member> members) throws Exception {
        AbstractGenericOperation so = new CreateMemberSO();
        so.templateExecute(members, null);
        return ((CreateMemberSO) so).getId();
    }

    public List<GeneralEntity> getAllMembers() throws Exception {
        AbstractGenericOperation so = new GetMembersSO();
        so.templateExecute(new Member(), null);
        return ((GetMembersSO) so).getList();
    }

    public List<GeneralEntity> getAllMembers(String keywordMember) throws Exception {
        AbstractGenericOperation so = new SearchMembersSO();
        so.templateExecute(new Member(), keywordMember);
        return ((SearchMembersSO) so).getList();
    }

    public boolean deleteMember(Member member) throws Exception {
        AbstractGenericOperation so = new DeleteMemberSO();
        so.templateExecute(member, null);
        return ((DeleteMemberSO) so).isSuccessful();
    }

    // ====================================================================
    //Projection operations
    public List<GeneralEntity> saveAllProjections(List<Projection> projections) throws Exception {
        AbstractGenericOperation so = new SaveProjectionsSO();
        so.templateExecute(projections, null);
        return ((SaveProjectionsSO) so).getProjections();
    }

    public List<GeneralEntity> getAllProjections() throws Exception {
        AbstractGenericOperation so = new GetProjectionsSO();
        so.templateExecute(new Projection(), null);
        return ((GetProjectionsSO) so).getProjections();
    }

    public List<GeneralEntity> getAllProjectionsOrdered(String keywordProjection) throws Exception {
        AbstractGenericOperation so = new SearchProjectionsSO();
        so.templateExecute(new Projection(), keywordProjection);
        return ((SearchProjectionsSO) so).getProjections();
    }

    // ====================================================================
    //Reservation operations
    public long saveReservation(List<Reservation> reservations) throws Exception {
        AbstractGenericOperation so = new CreateReservationSO();
        so.templateExecute(reservations, null);
        return ((CreateReservationSO) so).getId();

    }
}
