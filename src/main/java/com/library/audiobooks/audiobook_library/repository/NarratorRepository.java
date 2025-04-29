package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Narrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NarratorRepository extends JpaRepository<Narrator, Long> {
  // queries
}
