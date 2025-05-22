package com.library.audiobooks.audiobook_library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {
  private Long id;
  private Date createdDate = new Date();
  private String firstName;
  private String lastName;
}
