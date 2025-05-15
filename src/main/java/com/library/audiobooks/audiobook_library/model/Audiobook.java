package com.library.audiobooks.audiobook_library.model;


import brave.internal.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Audiobook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "audiobook_title", nullable = false)
  private String audiobookTitle;

  @ManyToOne
  @JoinColumn(name = "fk_genre_id")
  private Genre genre;

  @ManyToOne
  @JoinColumn(name = "fk_owner_id")
  private Owner owner;

  @Column(name = "description", length = 512)
  private String description;

  @Column(name = "series_installment")
  private String seriesInstallment;

  @Column(name = "duration")
  private String duration;

  @Column(name = "created_dt", nullable = false)
  private Date createdDate = new Date();

  @Column(name = "last_updated_dt")
  private Date lastUpdatedDate;

  @ManyToOne
  @JoinColumn(name = "fk_series_id")
  private Series series;

  @ManyToMany
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OrderBy("lastName ASC, firstName ASC")
  @Nullable
  @JoinTable(
          name = "audiobook_author",
          joinColumns = @JoinColumn(name = "audiobook_id"),
          inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors;

  @ManyToMany
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OrderBy("lastName ASC, firstName ASC")
  @JoinTable(
          name = "audiobook_narrator",
          joinColumns = @JoinColumn(name = "audiobook_id"),
          inverseJoinColumns = @JoinColumn(name = "narrator_id")
  )
  private Set<Narrator> narrators = new HashSet<>();

  // You can add other custom logic for getting the author if needed, such as getting the first author if you have a single author
  public Author getFirstAuthor() {
    return authors.stream().findFirst().orElse(null); // Returns the first author or null if none
  }

  // convenience method
  public void addAuthor(Author theAuthor) {
    if(authors == null) {
      authors = new HashSet<>();
    }
    authors.add(theAuthor);
    theAuthor.addAudiobook(this);
  }
}
