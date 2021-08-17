package com.best0167.lol.lolcustomrecord.web.dto.participants;

import com.best0167.lol.lolcustomrecord.domain.participant.Participants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParticipantsListResponseDto {

    private final Long id;
    private final String name;
    private final String afreecaId;
    private final String afreecaNickname;
    private final String lineTier;

    public ParticipantsListResponseDto(Participants entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.afreecaId = entity.getAfreecaId();
        this.afreecaNickname = entity.getAfreecaNickname();
        this.lineTier = entity.getLineTier();
    }
}
