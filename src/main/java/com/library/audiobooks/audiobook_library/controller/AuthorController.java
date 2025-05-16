package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }


  // GET ALL
  @GetMapping
  public ResponseEntity<List<Author>> getAllAuthors() {
    return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
  }

  // GET BY ID or other PARAM
  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(
          @PathVariable Long id
  ) {
    Author author = authorService.getAuthorById(id);
    return ResponseEntity.status(HttpStatus.OK).body(author);
  }

  // POST
  @PostMapping
  public ResponseEntity<Author> createAuthor(
          @RequestBody AuthorDTO authorToCreate
  ) {
    Author createdAuthor = authorService.createAuthor(authorToCreate);
    return ResponseEntity.status(HttpStatus.OK).body(createdAuthor);
  }

  // PUT
  @PutMapping("/{id}")
  public ResponseEntity<Author> updateAuthor(
          @PathVariable Long id,
          @RequestBody AuthorDTO authorToUpdate
  ) {
    Author author = authorService.updateAuthor(authorToUpdate, id);
    return ResponseEntity.status(HttpStatus.OK).body(author);
  }

  // DELETE BY ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteAuthor(
          @PathVariable Long id
  ) {
    authorService.deleteAuthor(id);
    return ResponseEntity.status(HttpStatus.OK).body(id);
  }
}
