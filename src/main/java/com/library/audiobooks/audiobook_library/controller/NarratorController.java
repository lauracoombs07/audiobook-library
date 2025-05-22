package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.dto.NarratorCompleteDTO;
import com.library.audiobooks.audiobook_library.dto.NarratorDTO;
import com.library.audiobooks.audiobook_library.dto.OwnerDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Narrator;
import com.library.audiobooks.audiobook_library.model.Owner;
import com.library.audiobooks.audiobook_library.service.NarratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/narrators")
public class NarratorController {

  private final NarratorService narratorService;

  public NarratorController(NarratorService narratorService) {
    this.narratorService = narratorService;
  }

  /**
   * Get All {@link Narrator}
   * @return List of {@link Narrator}
   */
  @GetMapping
  public ResponseEntity<List<Narrator>> getAllNarrators() {
    return ResponseEntity.status(HttpStatus.OK).body(narratorService.getAllNarrators());
  }

  /**
   * Get {@link Narrator} by optional Request Param
   *
   * @param id        optional id
   * @param lastName  optional lastName
   * @param firstName optional firstName
   * @return Narrator
   */
  @GetMapping("/narrator")
  public ResponseEntity<List<Narrator>> getNarratorsByRequestParam(
          @RequestParam Optional<Long> id,
          @RequestParam Optional<String> lastName,
          @RequestParam Optional<String> firstName
  ) {
    List<Narrator> foundNarrators = new ArrayList<>();
    if (id.isPresent()) {
      foundNarrators.add(narratorService.getNarratorById(id.get()));
    }
    if (lastName.isPresent()) {
      foundNarrators = narratorService.getNarratorByLastName(lastName.get());
    }
    if (firstName.isPresent()) {
      foundNarrators = narratorService.getNarratorByFirstName(firstName.get());
    }

    return ResponseEntity.status(HttpStatus.OK).body(foundNarrators);
  }

  /**
   * Create new {@link Narrator}
   *
   * @param narratorToCreate {@link NarratorDTO}
   *
   * @return {@link Narrator}
   */
  @PostMapping("/narrator")
  public ResponseEntity<Narrator> createNarrator(
          @RequestBody NarratorDTO narratorToCreate
  ) {
    Narrator createdNarrator = narratorService.createNarrator(narratorToCreate);
    return ResponseEntity.status(HttpStatus.OK).body(createdNarrator);
  }

}
