package com.lincentpega.localp2p.api;

import lombok.Data;

@Data
public class ErrorResponse {

    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }
}
