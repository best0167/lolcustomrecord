package com.best0167.lol.lolcustomrecord.web.dto;

import com.best0167.lol.lolcustomrecord.exception.LCustomErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LCustomErrorResponse {
    private LCustomErrorCode errorCode;
    private String errorMessage;
}
