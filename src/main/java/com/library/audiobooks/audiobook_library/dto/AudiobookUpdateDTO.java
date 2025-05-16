package com.library.audiobooks.audiobook_library.dto;

import com.library.audiobooks.audiobook_library.model.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data // getters and setters
public class AudiobookUpdateDTO {
  private Long id;
  private String audiobookTitle;
  private String description;
  private String seriesInstallment;
  private String duration;
  private Date createdDate;

  private Genre genre;
  private Owner owner;
  private Series series;
  private Set<Author> authors;
  private Set<Narrator> narrators;
}

