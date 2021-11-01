package com.best0167.lol.lolcustomrecord.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LCustomErrorCode {
    NO_PARTICIPANT("등록되지 않은 롤 닉네임입니다."),
    DUPLICATED_NAME("중복되는 롤 닉네임이 있습니다."),

    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다"),
    INVALID_REQUEST("잘못된 요청입니다.");

    private final String message;
}
