package com.library.audiobooks.audiobook_library.dto;

import com.library.audiobooks.audiobook_library.model.Audiobook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NarratorCompleteDTO {
  private String firstName;
  private String lastName;
  private Date createdDate = new Date();
  private Set<Audiobook> audiobooks;
}
