package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.dto.GenreDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Genre;
import com.library.audiobooks.audiobook_library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

  private final GenreService genreService;

  @Autowired
  public  GenreController(GenreService genreService) { this.genreService = genreService; }

  /**
   * Get All {@link com.library.audiobooks.audiobook_library.model.Genre}
   *
   * @return List of {@link com.library.audiobooks.audiobook_library.model.Genre}
   */
  @GetMapping
  public ResponseEntity<List<Genre>> getAllGenres() {
    return ResponseEntity.status(HttpStatus.OK).body(genreService.getAllGenres());
  }

  /**
   * Create new {@link Genre}
   *
   * @param genreToCreate {@link GenreDTO}
   *
   * @return {@link Genre}
   */
  @PostMapping("/genre")
  public ResponseEntity<Genre> createGenre(
          @RequestBody GenreDTO genreToCreate
  ) {
    Genre createdGenre = genreService.createGenre(genreToCreate);
    return ResponseEntity.status(HttpStatus.OK).body(createdGenre);
  }


  /**
   * Update existing {@link Genre}
   *
   * @param genreToUpdate {@link GenreDTO}
   *
   * @return {@link Genre}
   */
  @PutMapping("/genre/{genreName}")
  public ResponseEntity<Genre> createGenre(
          @PathVariable String genreName,
          @RequestBody GenreDTO genreToUpdate
  ) {
    Genre createdGenre = genreService.updateGenre(genreName, genreToUpdate);
    return ResponseEntity.status(HttpStatus.OK).body(createdGenre);
  }
}
