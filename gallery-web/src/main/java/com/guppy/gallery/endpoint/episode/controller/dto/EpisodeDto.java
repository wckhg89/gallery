package com.guppy.gallery.endpoint.episode.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EpisodeDto {

    private long episodeId;
    private String episodeName;
    private String episodeDescription;
    private List<Image> images;

    @Builder
    public EpisodeDto(long episodeId, String episodeName, String episodeDescription, List<Image> images) {
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.images = images;
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Image {
        private int index;
        private String imagePath;
        private String src;
        private String description;
        private List<String> hashTags;

        @Builder
        public Image(int index, String imagePath, String src, String description, List<String> hashTags) {
            this.index = index;
            this.imagePath = imagePath;
            this.src = src;
            this.description = description;
            this.hashTags = hashTags;
        }
    }
}
