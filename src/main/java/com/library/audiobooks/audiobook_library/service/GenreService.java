package com.library.audiobooks.audiobook_library.service;

import com.library.audiobooks.audiobook_library.dto.GenreDTO;
import com.library.audiobooks.audiobook_library.model.Genre;
import com.library.audiobooks.audiobook_library.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

  private final GenreRepository genreRepository;

  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }

  public Genre createGenre(GenreDTO genreDTO) {
    Genre genreDAO = new Genre();
    BeanUtils.copyProperties(genreDTO, genreDAO);

    return genreRepository.save(genreDAO);
  }

  public Genre updateGenre(String genreName, GenreDTO genreDTO) {
    Genre existingGenre = genreRepository.findByGenre(genreName)
            .orElseThrow(() -> new RuntimeException("Genre with this name does not exist in the database"));
    BeanUtils.copyProperties(genreDTO, existingGenre);

    return genreRepository.save(existingGenre);
  }

}
