package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
  // queries
}
