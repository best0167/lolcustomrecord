package com.best0167.lol.lolcustomrecord.web.dto.matches;

import com.best0167.lol.lolcustomrecord.domain.match.Matches;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MatchesSaveRequestDto {

    private int season;
    private int day;
    private String victoryTeam;
    private String blueTopNickname;
    private String blueJungleNickname;
    private String blueMidNickname;
    private String blueBotNickname;
    private String blueSupportNickname;
    private String redTopNickname;
    private String redJungleNickname;
    private String redMidNickname;
    private String redBotNickname;
    private String redSupportNickname;
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
    public MatchesSaveRequestDto(int season, int day, String victoryTeam, String blueTopNickname, String blueJungleNickname, String blueMidNickname, String blueBotNickname, String blueSupportNickname, String redTopNickname, String redJungleNickname, String redMidNickname, String redBotNickname, String redSupportNickname, String blueTopChampion, String blueJungleChampion, String blueMidChampion, String blueBotChampion, String blueSupportChampion, String redTopChampion, String redJungleChampion, String redMidChampion, String redBotChampion, String redSupportChampion) {
        this.season = season;
        this.day = day;
        this.victoryTeam = victoryTeam;
        this.blueTopNickname = blueTopNickname;
        this.blueJungleNickname = blueJungleNickname;
        this.blueMidNickname = blueMidNickname;
        this.blueBotNickname = blueBotNickname;
        this.blueSupportNickname = blueSupportNickname;
        this.redTopNickname = redTopNickname;
        this.redJungleNickname = redJungleNickname;
        this.redMidNickname = redMidNickname;
        this.redBotNickname = redBotNickname;
        this.redSupportNickname = redSupportNickname;
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

    public Matches toEntity() {
        return Matches.builder()
                .season(season)
                .day(day)
                .victoryTeam(victoryTeam)
                .blueTopNickname(blueTopNickname)
                .blueJungleNickname(blueJungleNickname)
                .blueMidNickname(blueMidNickname)
                .blueBotNickname(blueBotNickname)
                .blueSupportNickname(blueSupportNickname)
                .redTopNickname(redTopNickname)
                .redJungleNickname(redJungleNickname)
                .redMidNickname(redMidNickname)
                .redBotNickname(redBotNickname)
                .redSupportNickname(redSupportNickname)
                .blueTopChampion(blueTopChampion)
                .blueJungleChampion(blueJungleChampion)
                .blueMidChampion(blueMidChampion)
                .blueBotChampion(blueBotChampion)
                .blueSupportChampion(blueSupportChampion)
                .redTopChampion(redTopChampion)
                .redJungleChampion(redJungleChampion)
                .redMidChampion(redMidChampion)
                .redBotChampion(redBotChampion)
                .redSupportChampion(redSupportChampion)
                .build();
    }
}
