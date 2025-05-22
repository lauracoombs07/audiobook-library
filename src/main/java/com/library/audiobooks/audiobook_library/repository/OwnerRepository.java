package com.library.audiobooks.audiobook_library.repository;

import com.library.audiobooks.audiobook_library.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

  List<Owner> findAllByFirstName(String firstName);

  List<Owner> findAllByLastName(String lastName);

  Optional<Owner> findByFirstNameAndLastName(String firstName, String lastName);

}
