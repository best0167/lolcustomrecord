package com.best0167.lol.lolcustomrecord.domain.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantsRepository extends JpaRepository<Participants, Long> {
    Optional<Participants> findByName(String name);
}
