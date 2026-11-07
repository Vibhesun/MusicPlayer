
package com.musicplayer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "playlist_songs",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"playlist_id", "song_id"}
    )
)
@Getter
@Setter
@NoArgsConstructor
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(nullable = false)
    private Integer position = 0;
}
