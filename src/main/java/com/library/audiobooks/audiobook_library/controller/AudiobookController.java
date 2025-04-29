package com.library.audiobooks.audiobook_library.controller;

import com.library.audiobooks.audiobook_library.dto.AudiobookDTO;
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

  @GetMapping
  public List<Audiobook> getAllAudiobooks() {
    return audiobookService.getAllAudiobooks();
  }

  @GetMapping("/{id}")
  public Optional<Audiobook> getAudiobookById(@PathVariable Long id) {
    return audiobookService.getAudiobookById(id);
  }


  @PostMapping
  public ResponseEntity<Audiobook> createAudiobook(@RequestBody AudiobookDTO audiobookDTO) {
    Audiobook createdAudiobook = audiobookService.createAudiobook(audiobookDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdAudiobook);
  }
  // Add more endpoints as needed for other CRUD operations
}
