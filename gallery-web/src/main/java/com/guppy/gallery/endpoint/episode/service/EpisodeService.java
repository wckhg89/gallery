package com.guppy.gallery.endpoint.episode.service;

import com.guppy.gallery.domain.Episode;
import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeDto;
import com.guppy.gallery.endpoint.episode.controller.dto.EpisodeInfoDto;
import com.guppy.gallery.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;


    public List<EpisodeInfoDto> getEpisodeInfos () {
        return episodeRepository.findAll().stream()
                .map(episode -> EpisodeInfoDto.builder()
                        .episodeId("1-" + episode.getId())
                        .episodePath("/episode/" + episode.getId())
                        .episodeName(episode.getEpisodeName())
                        .episodeDescription(episode.getEpisodeDescription())
                .build())
                .collect(toList());
    }

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
                                            .hashTags(it.getHashTags())
                                            .likeCount(it.getLikeCount())
                                            .build();
                                }).collect(toList()))
                        .build())
                .orElseThrow(IllegalArgumentException::new);
    }

    public long saveEpisode (long episodeId, int imageIndex) {
        Episode episode = episodeRepository.findById(episodeId)
                .orElseThrow(IllegalArgumentException::new);

        episode.increaseImageLikeCount(imageIndex);

        return episodeRepository.save(episode).getId();
    }

}
