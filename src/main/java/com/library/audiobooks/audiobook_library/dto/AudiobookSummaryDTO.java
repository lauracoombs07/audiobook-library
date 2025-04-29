package com.library.audiobooks.audiobook_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This avoids circular nesting and keeps things clean:
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudiobookSummaryDTO {
  private Long id;
  private String title;
}
