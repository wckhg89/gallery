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
    public Episode(long id, int episodeSeq, String episodeName, String episodeDescription, List<Image> images) {
        this.id = id;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.images = images;

    }

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Image {
        private long index;
        private String src;
        private String description;

        @Builder
        public Image(long index, String src, String description) {
            this.index = index;
            this.src = src;
            this.description = description;
        }

    }

    public void generateImageIndex () {
        for (int idx = 0 ; idx < this.images.size() ; idx ++) {
            this.images.get(idx).index = idx;
        }
    }
}
