package com.best0167.lol.lolcustomrecord.domain.histories;

import com.best0167.lol.lolcustomrecord.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class histories extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int season;

    private int day;

    private String line;

    private String champion;

    private int victory;

    private int defeat;

    private int score;


}
