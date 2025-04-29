package com.library.audiobooks.audiobook_library.dto;

import java.util.List;

public class AudiobookRequest {
  private String title;
  private String genre;
  private String description;
  private String duration;
  private List<Long> authorIds;  // List of author IDs (instead of the actual Author objects)

  // Getters and setters (or use Lombok @Data)
}
