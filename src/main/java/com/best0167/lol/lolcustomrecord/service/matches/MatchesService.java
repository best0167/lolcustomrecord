package com.best0167.lol.lolcustomrecord.service.matches;

import com.best0167.lol.lolcustomrecord.domain.match.Matches;
import com.best0167.lol.lolcustomrecord.domain.match.MatchesRepository;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesListResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesResponseDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchesService {

    private final MatchesRepository matchesRepository;

    @Transactional
    public Long save(MatchesSaveRequestDto requestDto) {
        return matchesRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MatchesUpdateRequestDto requestDto) {
        Matches matches = matchesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 매치가 없습니다. id=" + id));

        matches.update(requestDto.getVictoryTeam(), requestDto.getBlueTopChampion(), requestDto.getBlueJungleChampion(), requestDto.getBlueMidChampion(),
                requestDto.getBlueBotChampion(), requestDto.getBlueSupportChampion(), requestDto.getRedTopChampion(), requestDto.getRedJungleChampion(),
                requestDto.getRedMidChampion(), requestDto.getRedBotChampion(), requestDto.getRedSupportChampion());

        return id;
    }

    @Transactional(readOnly = true)
    public MatchesResponseDto findById(Long id) {
        Matches entity = matchesRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 매치가 없습니다. id=" + id));

        return new MatchesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MatchesListResponseDto> findAllDesc(Long id) {
        return matchesRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(MatchesListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Matches matches = matchesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 매치가 없습니다. id=" + id));

        matchesRepository.delete(matches);
    }
}
