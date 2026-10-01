package com.test.copamw.constants;

public class GlobalConstants {

    private GlobalConstants() {
    }

    public static final String INIT_SAVE_COMMENT = "Processing comment for show {}";
    public static final String SAVE_COMMENT = "Saving comment for show {} with rating {}";
    public static final String REQUEST_SHOW = "Request show {} from TV Maze";
    public static final String SAVE_MONGO = "Show {} saved in MongoDB cache";
    public static final String FOUND_TVMAZE = "Show {} not found in MongoDB. Calling TV Maze";
    public static final String FOUND_MONGO = "Show {} found in MongoDB cache";
    public static final String EXECUTE_SEARCH_SHOW_MESSAGE = "execute {} search Shows";
    public static final String ENDPOINT_SEARCH = "/search";
    public static final String ENDPOINT_SHOW_ID = "/{showId}";
    public static final String TVMAZE_SHOW_PATH_ID = "/shows/{showId}";
    public static final String TVMAZE_SEARCH_PATH = "/search/shows";
    public static final String TVMAZE_QUERY_PARAM = "q";
    public static final String SEARCH_QUERY_PARAM = "search_query";
    public static final String BAD_REQUEST = "Bad Request";
    public static final String BAD_GATEWAY = "Bad Gateway";
    public static final String TVMAZE_SERVICE_ERROR =
            "Unable to retrieve shows from TVMaze";
    public static final String SEARCH_QUERY_EMPTY =
            "search_query not empty";
    public static final String SEARCH_QUERY_MISSING =
            "search_query must not be missing";
}
