package com.best0167.lol.lolcustomrecord.web.dto;

import com.best0167.lol.lolcustomrecord.domain.posts.Posts;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostsListResponseDto {
    private final Long id;
    private final String title;
    private final String author;
    private final LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
