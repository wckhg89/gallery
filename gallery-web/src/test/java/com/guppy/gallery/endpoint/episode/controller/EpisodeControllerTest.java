package com.guppy.gallery.endpoint.episode.controller;

import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.endpoint.episode.service.EpisodeService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@ExtendWith({RestDocumentationExtension.class, MockitoExtension.class})
class EpisodeControllerTest {

    @Mock
    private EpisodeService episodeService;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        standaloneSetup(
                MockMvcBuilders.standaloneSetup(new EpisodeController(episodeService))
                        .apply(documentationConfiguration(restDocumentation))
        );
    }

    @Test
    void givenEpisodeId_whenEpisodeExist_thenReturnEpisodeDtoWith200() {
        // Given
        long episodeId = 1L;
        BDDMockito.given(episodeService.getEpisode(episodeId)).willReturn(EpisodeDto.builder()
                .episodeId(episodeId)
                .build());

        MockMvcResponse response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Content-Type", "Application/json")
                .when()
                .get("/api/episodes/" + episodeId);

        // When

        // Then
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    void givenEpisodeId_whenEpisodeNotExist_thenReturnEpisodeDtoWith204() {
        // Given
        long episodeId = 1L;
        BDDMockito.given(episodeService.getEpisode(1L)).willThrow(new IllegalArgumentException());

        MockMvcResponse response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Content-Type", "Application/json")
                .when()
                .get("/api/episodes/" + episodeId);

        // When

        // Then
        response.then().statusCode(204);
        response.prettyPrint();
    }
}