package com.best0167.lol.lolcustomrecord.web.dto.participants;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantsUpdateRequestDto {

    private String name;
    private String afreecaId;
    private String afreecaNickname;
    private String lineTier;


    @Builder
    public ParticipantsUpdateRequestDto(String name, String afreecaId, String afreecaNickname, String lineTier) {
        this.name = name;
        this.afreecaId = afreecaId;
        this.afreecaNickname = afreecaNickname;
        this.lineTier = lineTier;
    }

}
