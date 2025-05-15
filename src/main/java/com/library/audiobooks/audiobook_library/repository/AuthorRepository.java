package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  // queries

}
