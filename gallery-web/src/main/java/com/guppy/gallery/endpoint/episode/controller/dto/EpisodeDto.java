package com.guppy.gallery.endpoint.episode.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EpisodeDto {

    private int episodeId;
    private String episodeName;
    private String episodeDescription;
    private List<Image> images;

    @Builder
    public EpisodeDto(int episodeId, String episodeName, String episodeDescription, List<Image> images) {
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.images = images;
    }

    @NoArgsConstructor
    public static class Image {
        private int index;
        private String imagePath;
        private String src;

        @Builder
        public Image(int index, String imagePath, String src) {
            this.index = index;
            this.imagePath = imagePath;
            this.src = src;
        }
    }
}
