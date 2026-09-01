package by.sadovnick.forumservice.entity;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представляет публикацию пользователя на форуме.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private UUID id;
    private UUID authorId;
    private String title;
    private String content;
    private PostStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private long version;
}
