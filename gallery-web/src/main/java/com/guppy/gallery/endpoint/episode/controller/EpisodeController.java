package com.guppy.gallery.endpoint.episode.controller;

import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.endpoint.episode.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping("/{episodeId}")
    public ResponseEntity<EpisodeDto> getEpisode (@PathVariable long episodeId) {
        try {
            return ResponseEntity.ok(episodeService.getEpisode(episodeId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
