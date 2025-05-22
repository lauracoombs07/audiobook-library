package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Author;
import com.library.audiobooks.audiobook_library.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  // queries
  List<Author> findAllByFirstName(String firstName);

  List<Author> findAllByLastName(String lastName);
}
