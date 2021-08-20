package com.best0167.lol.lolcustomrecord.web.dto.histories;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class historiesResponseDto {

    private int season;
    private int total;
    private int score;

    @Builder
    public historiesResponseDto(int season, int total, int score) {
        this.season = season;
        this.total = total;
        this.score = score;
    }

}
