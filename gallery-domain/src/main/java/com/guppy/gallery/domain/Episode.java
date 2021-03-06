package com.guppy.gallery.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "episode")
public class Episode {

    @Transient
    public static final String SEQUENCE_NAME = "episode_sequence";

    @Id
    private long id;
    private String episodeName;
    private String episodeDescription;
    private List<Image> images;


    @Builder
    public Episode(long id, String episodeName, String episodeDescription, List<Image> images) {
        this.id = id;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.images = images;

    }

    public void increaseImageLikeCount (int imageIndex) {
        this.images.get(imageIndex).increaseLikeCount();
    }

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Image {
        private String src;
        private String description;
        private List<String> hashTags;
        private long likeCount;

        @Builder
        public Image(String src, String description, List<String> hashTags, long likeCount) {
            this.src = src;
            this.description = description;
            this.hashTags = hashTags;
            this.likeCount = likeCount;
        }

        public void increaseLikeCount () {
            this.likeCount += 1L;
        }
    }
}
