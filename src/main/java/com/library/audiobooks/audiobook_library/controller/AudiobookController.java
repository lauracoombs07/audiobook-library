package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AudiobookDTO;
import com.library.audiobooks.audiobook_library.dto.AudiobookUpdateDTO;
import com.library.audiobooks.audiobook_library.model.Audiobook;
import com.library.audiobooks.audiobook_library.service.AudiobookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/audiobooks")
public class AudiobookController {

  private final AudiobookService audiobookService;

  @Autowired
  public AudiobookController(AudiobookService audiobookService) {
    this.audiobookService = audiobookService;
  }

  // GET ALL
  @GetMapping
  public List<Audiobook> getAllAudiobooks() {
    return audiobookService.getAllAudiobooks();
  }

  // GET BY ID
  @GetMapping("/{id}")
  public Optional<Audiobook> getAudiobookById(@PathVariable Long id) {
    return audiobookService.getAudiobookById(id);
  }

  // POST
  @PostMapping
  public ResponseEntity<Audiobook> createAudiobook(@RequestBody AudiobookDTO audiobookDTO) {
    Audiobook createdAudiobook = audiobookService.createAudiobook(audiobookDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdAudiobook);
  }

  // PUT
  @PutMapping("/{id}")
  public ResponseEntity<Audiobook> updateAudiobookById(
          @PathVariable Long id,
          @RequestBody AudiobookUpdateDTO updatedAudiobookDTO
  ) {
    Audiobook updatedAudiobook = audiobookService.updateAudiobookById(updatedAudiobookDTO);
    System.out.println("UPDATED IN CONTROLLER" + updatedAudiobookDTO);
    return ResponseEntity.status(HttpStatus.OK).body(updatedAudiobook);
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteAudiobookById(@PathVariable Long id) {
    audiobookService.deleteAudiobookById(id);
    return ResponseEntity.status(HttpStatus.OK).body(id);
  }

}
