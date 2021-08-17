package com.best0167.lol.lolcustomrecord.web.dto.participants;

import com.best0167.lol.lolcustomrecord.domain.participant.Participants;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantsResponseDto {

    private Long id;
    private String name;
    private String afreecaId;
    private String afreecaNickname;
    private String lineTier;

    @Builder
    public ParticipantsResponseDto(Participants entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.afreecaId = entity.getAfreecaId();
        this.afreecaNickname = entity.getAfreecaNickname();
        this.lineTier = entity.getLineTier();
    }
}
