package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Narrator;
import com.library.audiobooks.audiobook_library.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NarratorRepository extends JpaRepository<Narrator, Long> {
  // queries
  List<Narrator> findAllByLastName(String lastName);
}
