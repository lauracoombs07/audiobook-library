package com.library.audiobooks.audiobook_library.dto;

import lombok.Data;

import java.util.List;

@Data // getters and setters
public class AudiobookDTO {
  private String title;
  private String genre;
  private String owner;
  private String description;
  private String seriesNumber;
  private String duration;
  private Long seriesId;
  private List<Long> authorIds;
  private List<Long> narratorIds;
}
