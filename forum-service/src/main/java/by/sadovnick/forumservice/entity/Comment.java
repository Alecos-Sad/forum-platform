package by.sadovnick.forumservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

/**
 * Представляет комментарий в обсуждении публикации.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "comments",
        indexes = {
            @Index(
                    name = "idx_comments_post_parent_created_at_id",
                    columnList = "post_id, parent_comment_id, created_at, id"),
            @Index(
                    name = "idx_comments_author_id_created_at_id",
                    columnList = "author_id, created_at, id")
        })
public class Comment {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "post_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_comments_post"))
    private Post post;

    @Column(name = "author_id", nullable = false, updatable = false)
    private UUID authorId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "parent_comment_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_comments_parent_comment"))
    private Comment parentComment;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommentStatus status;

    @CreationTimestamp
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE_UTC)
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE_UTC)
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Version
    @Column(name = "version", nullable = false)
    private long version;
}
