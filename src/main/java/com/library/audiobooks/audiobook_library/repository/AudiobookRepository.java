package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Audiobook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiobookRepository extends JpaRepository<Audiobook, Long> {
  // You can add custom queries here if needed

}
