package com.best0167.lol.lolcustomrecord.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MatchesUpdateRequestDto {

    private String victoryTeam;
    private String blueTopChampion;
    private String blueJungleChampion;
    private String blueMidChampion;
    private String blueBotChampion;
    private String blueSupportChampion;
    private String redTopChampion;
    private String redJungleChampion;
    private String redMidChampion;
    private String redBotChampion;
    private String redSupportChampion;

    @Builder
    public MatchesUpdateRequestDto(String victoryTeam, String blueTopChampion, String blueJungleChampion, String blueMidChampion, String blueBotChampion, String blueSupportChampion, String redTopChampion, String redJungleChampion, String redMidChampion, String redBotChampion, String redSupportChampion) {
        this.victoryTeam = victoryTeam;
        this.blueTopChampion = blueTopChampion;
        this.blueJungleChampion = blueJungleChampion;
        this.blueMidChampion = blueMidChampion;
        this.blueBotChampion = blueBotChampion;
        this.blueSupportChampion = blueSupportChampion;
        this.redTopChampion = redTopChampion;
        this.redJungleChampion = redJungleChampion;
        this.redMidChampion = redMidChampion;
        this.redBotChampion = redBotChampion;
        this.redSupportChampion = redSupportChampion;
    }





}
