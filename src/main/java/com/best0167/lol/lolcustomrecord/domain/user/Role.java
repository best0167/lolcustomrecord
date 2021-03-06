package com.best0167.lol.lolcustomrecord.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    BJ("ROLE_BJ", "비제이");


    private final String key;
    private final String title;
}
