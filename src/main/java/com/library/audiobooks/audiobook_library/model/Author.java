package com.library.audiobooks.audiobook_library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"first_name", "last_name"}))
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "created_dt", nullable = false)
  private Date createdDate = new Date();

  @Column(name = "last_modified_dt")
  private Date lastModifiedDate;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Audiobook> audiobooks = new HashSet<>();

  // convenience method
  public void addAudiobook(Audiobook theAudiobook) {
    if (audiobooks == null) {
      audiobooks = new HashSet<>();
    }
    audiobooks.add(theAudiobook);
    theAudiobook.addAuthor(this);
  }
}
