package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AuthorDTO;
import com.library.audiobooks.audiobook_library.dto.NarratorCompleteDTO;
import com.library.audiobooks.audiobook_library.dto.NarratorDTO;
import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Narrator;
import com.library.audiobooks.audiobook_library.service.NarratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/narrators")
public class NarratorController {

  private final NarratorService narratorService;

  public NarratorController(NarratorService narratorService) {
    this.narratorService = narratorService;
  }

  // GET ALL
  @GetMapping
  public ResponseEntity<List<Narrator>> getAllNarrators() {
    return ResponseEntity.status(HttpStatus.OK).body(narratorService.getAllNarrators());
  }

  // GET BY ID or other PARAM
  @GetMapping("/{id}")
  public ResponseEntity<NarratorCompleteDTO> getNarratorById(
          @PathVariable Long id
  ) {
    NarratorCompleteDTO narratorCompleteDTO = narratorService.getNarratorById(id);
    return ResponseEntity.status(HttpStatus.OK).body(narratorCompleteDTO);
  }

  // POST
  @PostMapping
  public ResponseEntity<Narrator> createNarrator(
          @RequestBody NarratorDTO narratorToCreate
  ) {
    Narrator createdNarrator = narratorService.createNarrator(narratorToCreate);
    return ResponseEntity.status(HttpStatus.OK).body(createdNarrator);
  }

}
