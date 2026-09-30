package com.test.copamw.constants;

public class GlobalConstants {

    private GlobalConstants() {
    }

    public static final String TVMAZE_SEARCH_PATH = "/search/shows";

    public static final String TVMAZE_QUERY_PARAM = "q";

    public static final String SEARCH_QUERY_PARAM = "search_query";

    public static final String BAD_REQUEST = "Bad Request";

    public static final String BAD_GATEWAY = "Bad Gateway";

    public static final String TVMAZE_SERVICE_ERROR =
            "Unable to retrieve shows from TVMaze";

    public static final String SEARCH_QUERY_BLANK =
            "search_query must not be blank";

    public static final String SEARCH_QUERY_MISSING =
            "search_query must not be missing";
}
