package com.lincentpega.localp2p.common.exceptions;

public class LogicException extends RuntimeException {

    public LogicException() {
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
