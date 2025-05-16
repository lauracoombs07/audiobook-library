package com.library.audiobooks.audiobook_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NarratorDTO {
  private String firstName;
  private String lastName;
  private Date createdDate = new Date();
}
