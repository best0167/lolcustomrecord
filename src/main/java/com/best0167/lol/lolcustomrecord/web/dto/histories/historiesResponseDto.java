package com.best0167.lol.lolcustomrecord.web.dto.histories;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class historiesResponseDto {

    private int season;
    private int day;
    private String line;
    private String champion;
    private int victory;
    private int defeat;
    private int score;

    @Builder
    public historiesResponseDto(int season, int day, String line, String champion, int victory, int defeat, int score) {
        this.season = season;
        this.day = day;
        this.line = line;
        this.champion = champion;
        this.victory = victory;
        this.defeat = defeat;
        this.score = score;
    }

}
