package com.guppy.gallery.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "episode")
public class GuestBook {

    @Id
    private String _id;

    private String content;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;

    @Builder
    public GuestBook(String _id, String content, LocalDateTime createdDate) {
        this._id = _id;
        this.content = content;
        this.createdDate = createdDate;
    }
}
