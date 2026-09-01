package by.sadovnick.forumservice.entity;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представляет комментарий в обсуждении публикации.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private UUID id;
    private UUID postId;
    private UUID authorId;
    private UUID parentCommentId;
    private String content;
    private CommentStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private long version;
}
