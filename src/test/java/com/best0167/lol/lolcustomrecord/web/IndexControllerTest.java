package com.best0167.lol.lolcustomrecord.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("메인페이지 로딩")
    void indexLoading() throws Exception {
        // given
        String body = this.restTemplate.getForObject("/", String.class);

        // when

        // then
        Assertions.assertThat(body).contains("index.html");
    }
}
