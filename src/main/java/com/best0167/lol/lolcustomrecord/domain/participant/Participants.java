package com.best0167.lol.lolcustomrecord.domain.participant;

import com.best0167.lol.lolcustomrecord.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Participants extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String afreecaId;

    @Column(nullable = false)
    private String afreecaNickname;

    @Column(nullable = false)
    private String lineTier;

    @Builder
    public Participants(String name, String afreecaId, String afreecaNickname, String lineTier) {
        this.name = name;
        this.afreecaId = afreecaId;
        this.afreecaNickname = afreecaNickname;
        this.lineTier = lineTier;
    }

    public Participants update(String name, String afreecaId, String afreecaNickname, String lineTier) {
        this.name = name;
        this.afreecaId = afreecaId;
        this.afreecaNickname = afreecaNickname;
        this.lineTier = lineTier;

        return this;
    }
}
