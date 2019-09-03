package com.guppy.gallery.endpoint.episode.controller.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EpisodeInfoDto {

    private String episodeId;
    private String episodeName;
    private String episodePath;
    private String episodeDescription;

    @Builder
    public EpisodeInfoDto(String episodeId, String episodeName, String episodePath, String episodeDescription) {
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.episodePath = episodePath;
        this.episodeDescription = episodeDescription;
    }
}
