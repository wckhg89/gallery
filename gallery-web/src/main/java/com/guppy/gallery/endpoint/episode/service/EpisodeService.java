package com.guppy.gallery.endpoint.episode.service;

import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;


    public EpisodeDto getEpisode(long episodeId) {
        AtomicInteger atomicInt = new AtomicInteger();

        return episodeRepository.findById(episodeId)
                .map(episode -> EpisodeDto.builder()
                        .episodeId(episode.getId())
                        .episodeName(episode.getEpisodeName())
                        .episodeDescription(episode.getEpisodeDescription())
                        .images(episode.getImages().stream()
                                .map(it -> {
                                    int index = atomicInt.getAndIncrement();
                                    return EpisodeDto.Image.builder()
                                            .index(index)
                                            .imagePath("/images/" + index)
                                            .src(it.getSrc())
                                            .description(it.getDescription())
                                            .build();
                                }).collect(toList()))
                        .build())
                .orElseThrow(IllegalArgumentException::new);
    }

}
