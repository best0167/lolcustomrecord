package com.best0167.lol.lolcustomrecord.web.controller;

import com.best0167.lol.lolcustomrecord.service.participants.ParticipantsService;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ParticipantsController {

    private final ParticipantsService participantsService;

    @PostMapping("/api/participants")
    public Long save(@RequestBody ParticipantsSaveRequestDto requestDto) {
        return participantsService.save(requestDto);
    }

    @PutMapping("/api/participants/{id}")
    public Long update(@PathVariable Long id, @RequestBody ParticipantsUpdateRequestDto requestDto) {
        return participantsService.update(id, requestDto);
    }

    @GetMapping("/participants/{id}")
    public ParticipantsResponseDto findById(@PathVariable Long id) {
        return participantsService.findById(id);
    }

    @DeleteMapping("/api/participants/{id}")
    public Long delete(@PathVariable Long id) {
        participantsService.delete(id);
        return id;
    }
}
