package com.best0167.lol.lolcustomrecord.service.participants;

import com.best0167.lol.lolcustomrecord.domain.participant.Participants;
import com.best0167.lol.lolcustomrecord.domain.participant.ParticipantsRepository;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsListResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ParticipantsService {

    private final ParticipantsRepository participantsRepository;

    @Transactional
    public Long save(ParticipantsSaveRequestDto requestDto) {
        return participantsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ParticipantsUpdateRequestDto requestDto) {
        Participants participant = participantsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 닉네임이 없습니다. id=" + id));

        participant.update(requestDto.getName(), requestDto.getAfreecaId(), requestDto.getAfreecaNickname(), requestDto.getLineTier());

        return id;
    }

    @Transactional(readOnly = true)
    public ParticipantsResponseDto findById(Long id) {
        Participants entity = participantsRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 닉네임이 없습니다. id=" + id));

        String afreecaId = entity.getAfreecaId();

        String afreecaPicture = "profile.img.afreecatv.com/LOGO/" + afreecaId.substring(0, 2) + afreecaId + afreecaId + ".jpg";

        return new ParticipantsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ParticipantsListResponseDto> findAllDesc(Long id) {
        return participantsRepository.findAll().stream()
                .map(ParticipantsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Participants participant = participantsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 닉네임이 없습니다. id=" + id));

        participantsRepository.delete(participant);
    }

}
