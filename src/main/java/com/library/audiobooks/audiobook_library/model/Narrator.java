package com.library.audiobooks.audiobook_library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Narrator {

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

  @ManyToMany(mappedBy = "narrators")
  @JsonIgnore
  @OrderBy("audiobookTitle ASC")
  private Set<Audiobook> audiobooks = new HashSet<>();

}
