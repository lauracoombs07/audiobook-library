package com.library.audiobooks.audiobook_library.dto;

import com.library.audiobooks.audiobook_library.model.Audiobook;
import com.library.audiobooks.audiobook_library.model.Genre;
import com.library.audiobooks.audiobook_library.model.Owner;
import com.library.audiobooks.audiobook_library.model.Series;
import lombok.Data;

import java.util.List;

@Data // getters and setters
public class AudiobookDTO {
  private String audiobookTitle;
  private Long genreId;
  private Long ownerId;
  private String description;
  private String seriesInstallment;
  private String duration;
  private Long seriesId;
  private List<Long> authorIds;
  private List<Long> narratorIds;
}


//public Audiobook toDAO() {
//
//}
