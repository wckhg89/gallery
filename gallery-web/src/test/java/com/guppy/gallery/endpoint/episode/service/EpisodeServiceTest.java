package com.guppy.gallery.endpoint.episode.service;

import com.guppy.gallery.domain.Episode;
import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.repository.EpisodeRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class EpisodeServiceTest {

    @Mock
    private EpisodeRepository episodeRepository;

    private EpisodeService episodeService;

    @BeforeEach
    void setUp() {
        episodeService = new EpisodeService(episodeRepository);
    }

    @Test
    void givenEpisodeId_whenFindEpisodeById_thenConvertEpisodeDto() {
        // Given
        long episodeId = 1L;
        given(episodeRepository.findById(episodeId))
                .willReturn(Optional.of(Episode.builder()
                        .id(episodeId)
                        .episodeName("에피소드 1")
                        .episodeDescription("첫번째, 에피소드입니다.")
                        .images(Lists.newArrayList(
                                Episode.Image.builder()
                                        .src("image1src.jpg")
                                        .description("첫번째 이미지")
                                        .build(),
                                Episode.Image.builder()
                                        .src("image2src.jpg")
                                        .description("두번째 이미지")
                                        .build()
                        ))
                        .build()));

        // When
        EpisodeDto episodeDto = episodeService.getEpisode(episodeId);


        // Then
        // check episodeDto
        assertNotNull(episodeDto);
        assertEquals(episodeId, episodeDto.getEpisodeId());


        //check imageDto
        List<EpisodeDto.Image> images = episodeDto.getImages();

        assertNotNull(images);
        assertEquals(2, images.size());
        assertEquals(0, images.get(0).getIndex());
        assertEquals(1, images.get(1).getIndex());
        assertEquals("/images/0", images.get(0).getImagePath());
        assertEquals("/images/1", images.get(1).getImagePath());
    }
}