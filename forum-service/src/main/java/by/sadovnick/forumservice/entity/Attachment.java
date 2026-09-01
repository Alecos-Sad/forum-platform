package by.sadovnick.forumservice.entity;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Хранит метаданные файла, прикрепленного к публикации.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

    private UUID id;
    private UUID postId;
    private String storageKey;
    private String originalFileName;
    private String mediaType;
    private long sizeBytes;
    private ZonedDateTime createdAt;
}
