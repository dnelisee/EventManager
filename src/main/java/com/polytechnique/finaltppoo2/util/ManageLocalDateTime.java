package com.polytechnique.finaltppoo2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageLocalDateTime {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /* Since it is an utility class, I should not be instancieted, so we 
     * block that by this exception in the default constructor
     */
    private ManageLocalDateTime() {
        throw new IllegalStateException("utility class");
    }

    public static String lDtToString(LocalDateTime lDt) {
        return(
            lDt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
        );
    }

    public static LocalDateTime stringToLdt(String lDtAsString) {
        return(
            LocalDateTime.parse(lDtAsString, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
        );
    }
}
