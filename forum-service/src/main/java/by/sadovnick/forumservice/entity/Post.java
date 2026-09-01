package by.sadovnick.forumservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

/**
 * Представляет публикацию пользователя на форуме.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "posts",
        indexes = {
            @Index(
                    name = "idx_posts_status_created_at_id",
                    columnList = "status, created_at, id"),
            @Index(
                    name = "idx_posts_author_id_created_at_id",
                    columnList = "author_id, created_at, id")
        })
public class Post {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "author_id", nullable = false, updatable = false)
    private UUID authorId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PostStatus status;

    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE_UTC)
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE_UTC)
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Version
    @Column(name = "version", nullable = false)
    private long version;
}
