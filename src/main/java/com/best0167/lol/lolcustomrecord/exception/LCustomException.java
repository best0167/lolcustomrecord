package com.best0167.lol.lolcustomrecord.exception;

import lombok.Getter;

@Getter
public class LCustomException extends RuntimeException {
    private LCustomErrorCode lCustomErrorCode;
    private String detailMessage;

    public LCustomException(LCustomErrorCode errorCode) {
        super(errorCode.getMessage());
        this.lCustomErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public LCustomException(LCustomErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.lCustomErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }

}
