package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  // queries

}
