package com.best0167.lol.lolcustomrecord.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileControllerUnitTest {

    @Test
    @DisplayName("real_profile 조회")
    void realProfileLookUp() {
        // given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        // when
        String profile = controller.profile();

        // then
        assertThat(profile).isEqualTo(expectedProfile);
    }
    
    @Test
    @DisplayName("real_profile이 없으면 첫 번째가 조회")
    void realProfileNotFirstLookUp() {
        // given
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        
        // when
        String profile = controller.profile();
        
        // then
        assertThat(profile).isEqualTo(expectedProfile);
    }
    
    @Test
    @DisplayName("active_profile이 없으면 default가 조회")
    void activeProfileNotDefaultLookUp() {
        // given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);
        
        // when
        String profile = controller.profile();
        
        // then
        assertThat(profile).isEqualTo(expectedProfile);
    }

}