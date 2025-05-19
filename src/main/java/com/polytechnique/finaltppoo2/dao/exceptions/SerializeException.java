package com.polytechnique.finaltppoo2.dao.exceptions;

public class SerializeException extends RuntimeException {

    public SerializeException(String processName, String message) {
        super(String.format("problem in %s process : %s", processName, message));
    }
}
