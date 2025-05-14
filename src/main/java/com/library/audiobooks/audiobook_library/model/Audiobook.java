package com.library.audiobooks.audiobook_library.model;


import brave.internal.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @Column(nullable = false)
  private String title;

  private String genre;

  private String owner; // or location?

  @Column(name = "description", length = 512)
  private String description;

  @Column(name = "series_number")
  private String seriesNumber;

  @Column(name = "duration")
  private String duration;

  @ManyToOne
  @JoinColumn(name = "series_id")
  private Series series;

  @ManyToMany
  @OrderBy("lastName ASC, firstName ASC")
  @Nullable
  @JoinTable(
          name = "audiobook_author",
          joinColumns = @JoinColumn(name = "audiobook_id"),
          inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<Author> authors;

  @ManyToMany
//  @OrderBy("lastName ASC, firstName ASC")
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
