package com.best0167.lol.lolcustomrecord.web.dto.participants;

import com.best0167.lol.lolcustomrecord.domain.participant.Participants;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantsSaveRequestDto {

    private String name;
    private String afreecaId;
    private String afreecaNickname;
    private String lineTier;

    @Builder
    public ParticipantsSaveRequestDto(String name, String afreecaId, String afreecaNickname, String lineTier) {
        this.name = name;
        this.afreecaId = afreecaId;
        this.afreecaNickname = afreecaNickname;
        this.lineTier = lineTier;
    }

    public Participants toEntity() {
        return Participants.builder()
                .name(name)
                .afreecaId(afreecaId)
                .afreecaNickname(afreecaNickname)
                .lineTier(lineTier)
                .build();
    }
}
