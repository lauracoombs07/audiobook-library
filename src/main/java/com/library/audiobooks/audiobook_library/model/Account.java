package com.library.audiobooks.audiobook_library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"location", "username"}))
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String location;

  private String username;

  private String password;

  @Column(name = "created_dt", nullable = false)
  private Date createdDate = new Date();

  @Column(name = "last_modified_dt")
  private Date lastModifiedDate;

  // Owner Table
  @ManyToOne
  @JoinColumn(name = "fk_owner_id")
  private Owner owner;

}
