package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
  // queries
}
