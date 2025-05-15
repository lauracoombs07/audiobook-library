package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
  // queries
}
