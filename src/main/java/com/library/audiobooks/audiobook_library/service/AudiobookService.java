package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.AudiobookDTO;
import com.library.audiobooks.audiobook_library.model.*;
import com.library.audiobooks.audiobook_library.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AudiobookService {

  private final AudiobookRepository audiobookRepository;
  private final AuthorRepository authorRepository;
  private final AuthorService authorService;
  private final GenreRepository genreRepository;
  private final NarratorRepository narratorRepository;
  private final OwnerRepository ownerRepository;
  private final SeriesRepository seriesRepository;

  public AudiobookService(AudiobookRepository audiobookRepository,
                          AuthorRepository authorRepository,
                          AuthorService authorService,
                          GenreRepository genreRepository,
                          NarratorRepository narratorRepository,
                          OwnerRepository ownerRepository,
                          SeriesRepository seriesRepository) {
    this.audiobookRepository = audiobookRepository;
    this.authorRepository = authorRepository;
    this.authorService = authorService;
    this.genreRepository = genreRepository;
    this.narratorRepository = narratorRepository;
    this.ownerRepository = ownerRepository;
    this.seriesRepository = seriesRepository;
  }

  public List<Audiobook> getAllAudiobooks() {
    return audiobookRepository.findAll();
  }

  public Optional<Audiobook> getAudiobookById(Long id) {
    return audiobookRepository.findById(id);
  }

  public Audiobook saveAudiobook(Audiobook audiobook) {
    return audiobookRepository.save(audiobook);
  }

//  public Audiobook createAudiobook(AudiobookDTO audiobookDTO) {
//    // Create a new Audiobook entity
//    Audiobook audiobook = new Audiobook();
//
//    // Use BeanUtils.copyProperties() to copy simple properties from DTO to entity
//    BeanUtils.copyProperties(audiobookDTO, audiobook);
//
//    // Handle Series (if applicable)
//    if (audiobookDTO.getSeriesId() != null) {
//      Series series = seriesRepository.findById(audiobookDTO.getSeriesId())
//              .orElseThrow(() -> new RuntimeException("Series not found"));
//      audiobook.setSeries(series);
//    }
//
//    // Handle Authors
//    if (audiobookDTO.getAuthorIds() != null) {
//      Set<Author> authors = authorRepository.findAllById(audiobookDTO.getAuthorIds());
//      audiobook.setAuthors(authors);
//    }
//
//    // Handle Narrators
//    if (audiobookDTO.getNarratorIds() != null) {
//      Set<Narrator> narrators = narratorRepository.findAllById(audiobookDTO.getNarratorIds());
//      audiobook.setNarrators(narrators);
//    }
//
//    // Save the Audiobook entity
//    return audiobookRepository.save(audiobook);
//  }
  // Convert Set<Author> to List<Long> for DTO
//    List<Long> authorIds = audiobook.getAuthors().stream()
//            .map(Author::getId)
//            .collect(Collectors.toList());
//    audiobookDTO.setAuthorIds(authorIds);

  public Audiobook createAudiobook(AudiobookDTO audiobookDTO) {
    // Convert DTO to entity
    Audiobook audiobook = new Audiobook();

    audiobook.setAudiobookTitle(audiobookDTO.getAudiobookTitle());
    audiobook.setDescription(audiobookDTO.getDescription());
    audiobook.setSeriesInstallment(audiobookDTO.getSeriesInstallment());
    audiobook.setDuration(audiobookDTO.getDuration());

    // Handle Genre
    // should be able to handle multiple genres.
    // Preferably a String list and look up by name
    if(audiobookDTO.getGenreId() != null) {
      Genre genre = genreRepository.findById(audiobookDTO.getGenreId())
              .orElseThrow(() -> new RuntimeException("Genre not found"));
      audiobook.setGenre(genre);
    }

    // Handle Owner
    if (audiobookDTO.getOwnerId() != null) {
      Owner owner = ownerRepository.findById(audiobookDTO.getOwnerId())
              .orElseThrow(() -> new RuntimeException("Owner does not exist in database"));
      audiobook.setOwner(owner);
    }

    // Handle Series (if applicable)
    if (audiobookDTO.getSeriesId() != null) {
      Series series = seriesRepository.findById(audiobookDTO.getSeriesId())
              .orElseThrow(() -> new RuntimeException("Series not found"));
      audiobook.setSeries(series);
    }

    // Handle Authors
    if (audiobookDTO.getAuthorIds() != null && !audiobookDTO.getAuthorIds().isEmpty()) {
      // Step 1: Load Authors from DB
      Set<Author> authors = authorService.findAuthorsByIds(audiobookDTO.getAuthorIds());
      // Step 2: Set only in the owning side
      audiobook.setAuthors(authors);
    } else {
      throw new RuntimeException("At least one author must be provided");
    }

    // Handle Narrators
    if (audiobookDTO.getNarratorIds() != null && !audiobookDTO.getNarratorIds().isEmpty()) {
      List<Narrator> narratorList = narratorRepository.findAllById(audiobookDTO.getNarratorIds());
      Set<Narrator> narrators = new HashSet<>(narratorList);  // Convert List to Set
      audiobook.setNarrators(narrators);  // Set narrators in audiobook
    } else {
      throw new RuntimeException("At least one Narrator must be provided");
    }

    // Save the Audiobook
    return audiobookRepository.save(audiobook);
  }


}
