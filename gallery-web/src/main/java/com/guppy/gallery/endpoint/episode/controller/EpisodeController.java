package com.guppy.gallery.endpoint.episode.controller;

import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.endpoint.episode.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping("/{episodeId}")
    public EpisodeDto getEpisode (@PathVariable long episodeId) {

        return EpisodeDto.builder()
                .images(Collections.singletonList(EpisodeDto.Image.builder()
                        .index(0)
                        .imagePath("/image/0")
                        .src("iamgeSrc")
                        .build()))
                .build();
    }
}
