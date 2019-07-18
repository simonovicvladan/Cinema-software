package transfer.util;

public interface Operation {

    public static final int OPERATION_LOGIN = 1;
    public static final int OPERATION_SHUTDOWN = -1;

    public static final int OPERATION_CREATE_MOVIE = 2;
    public static final int OPERATION_GET_ALL_MOVIES = 3;
    public static final int OPERATION_SEARCH_MOVIES = 4;
    public static final int OPERATION_DELETE_MOVIE = 5;
    
    public static final int OPERATION_SAVE_ALL_CINEMA_HALLS = 6;
    public static final int OPERATION_GET_ALL_CINEMA_HALLS = 7;
    public static final int OPERATION_SEARCH_CINEMA_HALLS = 8;
    
    public static final int OPERATION_SAVE_MEMBER = 9;
    public static final int OPERATION_GET_ALL_MEMBERS = 10;
    public static final int OPERATION_SEARCH_MEMBERS = 11;
    public static final int OPERATION_DELETE_MEMBER = 12;
    
    public static final int OPERATION_SAVE_ALL_PROJECTIONS = 13;
    public static final int OPERATION_GET_ALL_PROJECTIONS = 14;
    public static final int OPERATION_GET_ALL_PROJECTIONS_ORDERED = 15;
    
    public static final int OPERATION_SAVE_RESERVATION = 16;
    public static final int OPERATION_SAVE_ALL_RESERVATIONS = 17;

}
