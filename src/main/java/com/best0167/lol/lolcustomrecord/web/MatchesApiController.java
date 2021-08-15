package com.best0167.lol.lolcustomrecord.web;

import com.best0167.lol.lolcustomrecord.service.matches.MatchesService;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MatchesApiController {
    private final MatchesService matchesService;

    @PostMapping("/api/matches")
    public Long save(@RequestBody MatchesSaveRequestDto requestDto) {
        return matchesService.save(requestDto);
    }

    @PutMapping("/api/matches/{id}")
    public Long update(@PathVariable Long id, @RequestBody MatchesUpdateRequestDto requestDto) {
        return matchesService.update(id, requestDto);
    }

    @GetMapping("/api/matches/{id}")
    public MatchesResponseDto findById(@PathVariable Long id) {
        return matchesService.findById(id);
    }

    @DeleteMapping("/api/matches/{id}")
    public Long delete(@PathVariable Long id) {
        matchesService.delete(id);

        return id;
    }

}
