package com.best0167.lol.lolcustomrecord.web.dto.posts;

import com.best0167.lol.lolcustomrecord.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    // Entity 의 필드 중 일부만 사용
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
