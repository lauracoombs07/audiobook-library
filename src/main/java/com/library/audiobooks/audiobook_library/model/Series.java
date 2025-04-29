package com.library.audiobooks.audiobook_library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Series {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Added generation strategy
  private Long id;

  @Column(name = "series_name", nullable = false) // Renamed to avoid confusion with 'series' field
  private String series;

  @Column(name = "total_count", nullable = false)
  private Integer totalCount;
}
