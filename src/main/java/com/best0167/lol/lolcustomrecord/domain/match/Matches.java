package com.best0167.lol.lolcustomrecord.domain.match;

import com.best0167.lol.lolcustomrecord.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Matches extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int season;

    @Column(nullable = false)
    private int day;

    @Column(nullable = false)
    private String victoryTeam;

    @Column(nullable = false)
    private String blueTopNickname;

    @Column(nullable = false)
    private String blueJungleNickname;

    @Column(nullable = false)
    private String blueMidNickname;

    @Column(nullable = false)
    private String blueBotNickname;

    @Column(nullable = false)
    private String blueSupportNickname;

    @Column(nullable = false)
    private String redTopNickname;

    @Column(nullable = false)
    private String redJungleNickname;

    @Column(nullable = false)
    private String redMidNickname;

    @Column(nullable = false)
    private String redBotNickname;

    @Column(nullable = false)
    private String redSupportNickname;

    @Column(nullable = false)
    private String blueTopChampion;

    @Column(nullable = false)
    private String blueJungleChampion;

    @Column(nullable = false)
    private String blueMidChampion;

    @Column(nullable = false)
    private String blueBotChampion;

    @Column(nullable = false)
    private String blueSupportChampion;

    @Column(nullable = false)
    private String redTopChampion;

    @Column(nullable = false)
    private String redJungleChampion;

    @Column(nullable = false)
    private String redMidChampion;

    @Column(nullable = false)
    private String redBotChampion;

    @Column(nullable = false)
    private String redSupportChampion;

    @Builder
    public Matches(int season, int day, String victoryTeam, String blueTopNickname, String blueJungleNickname, String blueMidNickname, String blueBotNickname, String blueSupportNickname, String redTopNickname, String redJungleNickname, String redMidNickname, String redBotNickname, String redSupportNickname, String blueTopChampion, String blueJungleChampion, String blueMidChampion, String blueBotChampion, String blueSupportChampion, String redTopChampion, String redJungleChampion, String redMidChampion, String redBotChampion, String redSupportChampion) {
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

    public void update(String victoryTeam, String blueTopChampion, String blueJungleChampion, String blueMidChampion, String blueBotChampion, String blueSupportChampion, String redTopChampion, String redJungleChampion, String redMidChampion, String redBotChampion, String redSupportChampion) {
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
