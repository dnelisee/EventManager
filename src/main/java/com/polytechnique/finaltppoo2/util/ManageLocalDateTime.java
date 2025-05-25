package com.polytechnique.finaltppoo2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ManageLocalDateTime {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public default String lDtToString(LocalDateTime lDt) {
        return(
            lDt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
        );
    }

    public default LocalDateTime stringToLdt(String lDtAsString) {
        return(
            LocalDateTime.parse(lDtAsString, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
        );
    }
}
