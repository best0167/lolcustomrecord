package com.best0167.lol.lolcustomrecord.domain.histories;

import com.best0167.lol.lolcustomrecord.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Histories extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int season;

    @Column(nullable = false)
    private int day;

    @Column(nullable = false)
    private String line;

    @Column(nullable = false)
    private String champion;

    @Column(nullable = false)
    private int victory;

    @Column(nullable = false)
    private int defeat;

    @Column(nullable = false)
    private int score;


}
