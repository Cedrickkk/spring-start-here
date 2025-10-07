package org.spring.framework.sqch14ex1.models;

import org.springframework.http.HttpStatus;

public class SuccessResponse<T> {
    private final int status;
    private final String message;
    private final long timestamp;
    private final T data;

    public SuccessResponse(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }
}
