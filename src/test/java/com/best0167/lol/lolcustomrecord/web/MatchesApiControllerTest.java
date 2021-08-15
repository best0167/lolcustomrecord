package com.best0167.lol.lolcustomrecord.web;

import com.best0167.lol.lolcustomrecord.domain.match.Matches;
import com.best0167.lol.lolcustomrecord.domain.match.MatchesRepository;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.MatchesUpdateRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class MatchesApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @Autowired
    private MatchesRepository matchesRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        baseUrl = "http://localhost:" + port + "/api/matches";
    }

    @AfterEach
    void tearDown() {
        matchesRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("매치 등록 테스트")
    void matchSave() throws Exception {
        // given
        MatchesSaveRequestDto requestDto = MatchesSaveRequestDto.builder()
                .season(202101)
                .day(1)
                .victoryTeam("B")
                .blueTopNickname("불고기 맛있네")
                .blueJungleNickname("나는폭풍우다")
                .blueMidNickname("제발 나를 구해줘")
                .blueBotNickname("교촌치킨")
                .blueSupportNickname("보두한")
                .redTopNickname("팔보산의정기")
                .redJungleNickname("개고기 맛있네")
                .redMidNickname("손대현")
                .redBotNickname("그대의 달이 되길")
                .redSupportNickname("미소천사 갈리오")
                .blueTopChampion("케넨")
                .blueJungleChampion("엘리스")
                .blueMidChampion("이렐리아")
                .blueBotChampion("이즈리얼")
                .blueSupportChampion("파이크")
                .redTopChampion("비에고")
                .redJungleChampion("니달리")
                .redMidChampion("잭스")
                .redBotChampion("카이사")
                .redSupportChampion("레오나")
                .build();

        String url = baseUrl;

        // when
        ResponseEntity<Long> responseEntity = restTemplate.
                postForEntity(url, requestDto, Long.class);

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        // then
        List<Matches> all = matchesRepository.findAll();
        assertThat(all.get(0).getSeason()).isEqualTo(202101);
        assertThat(all.get(0).getDay()).isEqualTo(1);
        assertThat(all.get(0).getBlueTopNickname()).isEqualTo("불고기 맛있네");
        assertThat(all.get(0).getBlueJungleNickname()).isEqualTo("나는폭풍우다");
        assertThat(all.get(0).getBlueMidNickname()).isEqualTo("제발 나를 구해줘");
        assertThat(all.get(0).getBlueBotNickname()).isEqualTo("교촌치킨");
        assertThat(all.get(0).getBlueSupportNickname()).isEqualTo("보두한");
        assertThat(all.get(0).getRedTopNickname()).isEqualTo("팔보산의정기");
        assertThat(all.get(0).getRedJungleNickname()).isEqualTo("개고기 맛있네");
        assertThat(all.get(0).getRedMidNickname()).isEqualTo("손대현");
        assertThat(all.get(0).getRedBotNickname()).isEqualTo("그대의 달이 되길");
        assertThat(all.get(0).getRedSupportNickname()).isEqualTo("미소천사 갈리오");
        assertThat(all.get(0).getBlueTopChampion()).isEqualTo("케넨");
        assertThat(all.get(0).getBlueJungleChampion()).isEqualTo("엘리스");
        assertThat(all.get(0).getBlueMidChampion()).isEqualTo("이렐리아");
        assertThat(all.get(0).getBlueBotChampion()).isEqualTo("이즈리얼");
        assertThat(all.get(0).getBlueSupportChampion()).isEqualTo("파이크");
        assertThat(all.get(0).getRedTopChampion()).isEqualTo("비에고");
        assertThat(all.get(0).getRedJungleChampion()).isEqualTo("니달리");
        assertThat(all.get(0).getRedMidChampion()).isEqualTo("잭스");
        assertThat(all.get(0).getRedBotChampion()).isEqualTo("카이사");
        assertThat(all.get(0).getRedSupportChampion()).isEqualTo("레오나");
    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("매치 수정 테스트")
    void matchUpdate() throws Exception {

        Matches savedMatch = matchesRepository.save(Matches.builder()
                .season(202101)
                .day(1)
                .victoryTeam("B")
                .blueTopNickname("불고기 맛있네")
                .blueJungleNickname("나는폭풍우다")
                .blueMidNickname("제발 나를 구해줘")
                .blueBotNickname("교촌치킨")
                .blueSupportNickname("보두한")
                .redTopNickname("팔보산의정기")
                .redJungleNickname("개고기 맛있네")
                .redMidNickname("손대현")
                .redBotNickname("그대의 달이 되길")
                .redSupportNickname("미소천사 갈리오")
                .blueTopChampion("케넨")
                .blueJungleChampion("엘리스")
                .blueMidChampion("이렐리아")
                .blueBotChampion("이즈리얼")
                .blueSupportChampion("파이크")
                .redTopChampion("비에고")
                .redJungleChampion("니달리")
                .redMidChampion("잭스")
                .redBotChampion("카이사")
                .redSupportChampion("레오나")
                .build());


        Long updateId = savedMatch.getId();

        String expectedVictoryTeam = "R";
        String expectedRedBotChampion = "베인";

        MatchesUpdateRequestDto requestDto = MatchesUpdateRequestDto.builder()
                .victoryTeam(expectedVictoryTeam)
                .redBotChampion(expectedRedBotChampion)
                .blueTopChampion("케넨")
                .blueJungleChampion("엘리스")
                .blueMidChampion("이렐리아")
                .blueBotChampion("이즈리얼")
                .blueSupportChampion("파이크")
                .redTopChampion("비에고")
                .redJungleChampion("니달리")
                .redMidChampion("잭스")
                .redSupportChampion("레오나")
                .build();

        String url = baseUrl + "/" + updateId;

        HttpEntity<MatchesUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate
                .exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        //then
        List<Matches> all = matchesRepository.findAll();
        assertThat(all.get(0).getVictoryTeam()).isEqualTo("R");
        assertThat(all.get(0).getRedBotChampion()).isEqualTo("베인");

    }

    @Test
    @WithMockUser(roles = "USER")
    @DisplayName("매치 삭제 테스트")
    void matchDelete() {
        // given
        Matches savedMatch = matchesRepository.save(Matches.builder()
                .season(202101)
                .day(1)
                .victoryTeam("B")
                .blueTopNickname("불고기 맛있네")
                .blueJungleNickname("나는폭풍우다")
                .blueMidNickname("제발 나를 구해줘")
                .blueBotNickname("교촌치킨")
                .blueSupportNickname("보두한")
                .redTopNickname("팔보산의정기")
                .redJungleNickname("개고기 맛있네")
                .redMidNickname("손대현")
                .redBotNickname("그대의 달이 되길")
                .redSupportNickname("미소천사 갈리오")
                .blueTopChampion("케넨")
                .blueJungleChampion("엘리스")
                .blueMidChampion("이렐리아")
                .blueBotChampion("이즈리얼")
                .blueSupportChampion("파이크")
                .redTopChampion("비에고")
                .redJungleChampion("니달리")
                .redMidChampion("잭스")
                .redBotChampion("카이사")
                .redSupportChampion("레오나")
                .build());

        Long deleteId = savedMatch.getId();

        String url = baseUrl + "/" + deleteId;

        // when
        matchesRepository.deleteById(deleteId);

        // then
        List<Matches> all = matchesRepository.findAll();
        assertThat(matchesRepository.findAll()).isEmpty();
    }



}