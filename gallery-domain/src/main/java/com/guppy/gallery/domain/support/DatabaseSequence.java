package com.guppy.gallery.domain.support;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;

    @Builder
    public DatabaseSequence(String id, long seq) {
        this.id = id;
        this.seq = seq;
    }
}
