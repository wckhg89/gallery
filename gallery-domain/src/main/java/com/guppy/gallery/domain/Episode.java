package com.guppy.gallery.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

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

    @Builder
    public Episode(long id, int episodeSeq, String episodeName, String episodeDescription) {
        this.id = id;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
    }
}
