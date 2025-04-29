package com.library.audiobooks.audiobook_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private List<AudiobookSummaryDTO> audiobooks;
}
