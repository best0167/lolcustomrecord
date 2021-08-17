package com.best0167.lol.lolcustomrecord.web.controller;

import com.best0167.lol.lolcustomrecord.domain.participant.Participants;
import com.best0167.lol.lolcustomrecord.domain.participant.ParticipantsRepository;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsSaveRequestDto;
import com.best0167.lol.lolcustomrecord.web.dto.participants.ParticipantsUpdateRequestDto;
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
class ParticipantsControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private ParticipantsRepository participantsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

    }

    @AfterEach
    void tearDown() {
        participantsRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "BJ")
    @DisplayName("닉네임 등록 테스트")
    void nicknamePost() throws Exception {
        //given
        String name = "에로니카";
        String afreecaId = "best0167";
        String afreecaNickname = "니카zz";
        String lineTier = "플5b골3d골1a플4a언랭e";

        ParticipantsSaveRequestDto requestDto = ParticipantsSaveRequestDto.builder()
                                                .name(name)
                                                .afreecaId(afreecaId)
                                                .afreecaNickname(afreecaNickname)
                                                .lineTier(lineTier)
                                                .build();

        String url = "http://localhost:" + port + "/api/participants";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.
                postForEntity(url, requestDto, Long.class);

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        //then
        List<Participants> all = participantsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo("에로니카");
        assertThat(all.get(0).getAfreecaId()).isEqualTo("best0167");
        assertThat(all.get(0).getAfreecaNickname()).isEqualTo("니카zz");
        assertThat(all.get(0).getLineTier()).isEqualTo("플5b골3d골1a플4a언랭e");
    }

    @Test
    @WithMockUser(roles = "BJ")
    @DisplayName("닉네임 수정 테스트")
    void nicknameUpdate() throws Exception {
        // given
        Participants savedParticipant = participantsRepository.save(Participants.builder()
                                        .name("에로니카")
                                        .afreecaId("best0167")
                                        .afreecaNickname("니카zz")
                                        .lineTier("플5b골3d골1a플4a언랭e")
                                        .build());

        Long updateId = savedParticipant.getId();

        String expectedLineTier = "골1b골3d골1a플4a언랭e";
        String afreecaNickname = "에로니카";

        ParticipantsUpdateRequestDto requestDto = ParticipantsUpdateRequestDto.builder()
                                                    .name("에로니카")
                                                    .afreecaId("best0167")
                                                    .afreecaNickname(afreecaNickname)
                                                    .lineTier(expectedLineTier)
                                                    .build();

        String url = "http://localhost:" + port + "/api/participants/" + updateId;

        HttpEntity<ParticipantsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate
                .exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        // then
        List<Participants> all = participantsRepository.findAll();
        assertThat(all.get(0).getLineTier()).isEqualTo("골1b골3d골1a플4a언랭e");
        assertThat(all.get(0).getAfreecaNickname()).isEqualTo("에로니카");
    }


    @Test
    @WithMockUser(roles = "BJ")
    @DisplayName("닉네임 삭제 테스트")
    void nicknameDelete() throws Exception {
        // given
        Participants savedParticipant = participantsRepository.save(Participants.builder()
                .name("에로니카")
                .afreecaId("best0167")
                .afreecaNickname("니카zz")
                .lineTier("플5b골3d골1a플4a언랭e")
                .build());

        Long deleteId = savedParticipant.getId();

        String url = "http://localhost:" + port + "/api/participants/" + deleteId;

        //when
        mvc.perform(delete(url))
                .andExpect(status().isOk());

        //then
        List<Participants> all = participantsRepository.findAll();
        assertThat(participantsRepository.findAll()).isEmpty();
    }
}