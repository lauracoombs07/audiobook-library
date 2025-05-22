package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Narrator;
import com.library.audiobooks.audiobook_library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }


  /**
   * Get All {@link Author}
   *
   * @return List of {@link Author}
   */
  @GetMapping
  public ResponseEntity<List<Author>> getAllAuthors() {
    return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
  }

  /**
   * Get {@link Author} by optional Request Param
   *
   * @param id        optional id
   * @param lastName  optional lastName
   * @param firstName optional firstName
   * @return {@link Author}
   */
  @GetMapping("/author")
  public ResponseEntity<List<Author>> getAuthorsByRequestParam(
          @RequestParam Optional<Long> id,
          @RequestParam Optional<String> lastName,
          @RequestParam Optional<String> firstName
  ) {
    List<Author> foundAuthors = new ArrayList<>();
    if (id.isPresent()) {
      foundAuthors.add(authorService.getAuthorById(id.get()));
    }
    if (lastName.isPresent()) {
      foundAuthors = authorService.getAuthorsByLastName(lastName.get());
    }
    if (firstName.isPresent()) {
      foundAuthors = authorService.getAuthorsByFirstName(firstName.get());
    }

    return ResponseEntity.status(HttpStatus.OK).body(foundAuthors);
  }

  /**
   * Create new {@link Author}
   *
   * @param authorToCreate {@link AuthorDTO}
   *
   * @return {@link Author}
   */
  @PostMapping("/author")
  public ResponseEntity<Author> createAuthor(
          @RequestBody AuthorDTO authorToCreate
  ) {
    Author createdAuthor = authorService.createAuthor(authorToCreate);
    return ResponseEntity.status(HttpStatus.OK).body(createdAuthor);
  }

  /**
   * Update existing {@link Author}
   *
   * @param authorToUpdate {@link AuthorDTO}
   *
   * @return {@link Author}
   */
  @PutMapping("/{id}")
  public ResponseEntity<Author> updateAuthor(
          @PathVariable Long id,
          @RequestBody AuthorDTO authorToUpdate
  ) {
    Author author = authorService.updateAuthor(authorToUpdate, id);
    return ResponseEntity.status(HttpStatus.OK).body(author);
  }

  /**
   * Delete existing {@link Author} by id
   *
   * @param id Long
   *
   * @return id Long
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteAuthor(
          @PathVariable Long id
  ) {
    authorService.deleteAuthor(id);
    return ResponseEntity.status(HttpStatus.OK).body(id);
  }
}
