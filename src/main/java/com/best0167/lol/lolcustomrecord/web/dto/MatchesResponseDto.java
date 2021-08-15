package com.best0167.lol.lolcustomrecord.web.dto;

import com.best0167.lol.lolcustomrecord.domain.match.Matches;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MatchesResponseDto {
    private final Long id;
    private final int season;
    private final int day;
    private final String victoryTeam;
    private final String blueTopNickname;
    private final String blueJungleNickname;
    private final String blueMidNickname;
    private final String blueBotNickname;
    private final String blueSupportNickname;
    private final String redTopNickname;
    private final String redJungleNickname;
    private final String redMidNickname;
    private final String redBotNickname;
    private final String redSupportNickname;
    private final String blueTopChampion;
    private final String blueJungleChampion;
    private final String blueMidChampion;
    private final String blueBotChampion;
    private final String blueSupportChampion;
    private final String redTopChampion;
    private final String redJungleChampion;
    private final String redMidChampion;
    private final String redBotChampion;
    private final String redSupportChampion;

    @Builder
    public MatchesResponseDto(Matches entity) {
        this.id = entity.getId();
        this.season = entity.getSeason();
        this.day = entity.getDay();
        this.victoryTeam = entity.getVictoryTeam();
        this.blueTopNickname = entity.getBlueTopNickname();
        this.blueJungleNickname = entity.getBlueJungleNickname();
        this.blueMidNickname = entity.getBlueMidNickname();
        this.blueBotNickname = entity.getBlueBotNickname();
        this.blueSupportNickname = entity.getBlueSupportNickname();
        this.redTopNickname = entity.getRedTopNickname();
        this.redJungleNickname = entity.getRedJungleNickname();
        this.redMidNickname = entity.getRedMidNickname();
        this.redBotNickname = entity.getRedBotNickname();
        this.redSupportNickname = entity.getRedSupportNickname();
        this.blueTopChampion = entity.getBlueTopChampion();
        this.blueJungleChampion = entity.getBlueJungleChampion();
        this.blueMidChampion = entity.getBlueMidChampion();
        this.blueBotChampion = entity.getBlueBotChampion();
        this.blueSupportChampion = entity.getBlueSupportChampion();
        this.redTopChampion = entity.getRedTopChampion();
        this.redJungleChampion = entity.getRedJungleChampion();
        this.redMidChampion = entity.getRedMidChampion();
        this.redBotChampion = entity.getRedBotChampion();
        this.redSupportChampion = entity.getRedSupportChampion();
    }
}
